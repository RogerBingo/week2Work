package org.geektimes.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserServiceImpl;

import javax.persistence.EntityTransaction;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Aspect
public class RegisterAspectj {

    @Before("execution (void TestAspectj.sayHello())")
    public void sayHello(){
        System.out.println("--------------Aspect-----------------");
    }

    @Before("execution (* org.geektimes.projects.user.service.UserServiceImpl.register(..))")
    public void beforeRegister(JoinPoint point){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        List<Object> args = Arrays.asList(point.getArgs());
        // 校验结果
        User user = (User) args.get(0);
        Set<ConstraintViolation<Object>> violations = validator.validate(user);
        if(violations.size() > 0){
            user.setSuccess(false);
            violations.forEach(c -> {
                System.out.println(c.getMessage());
            });
        }else {
            UserServiceImpl userServiceImpl = (UserServiceImpl) point.getThis();
            EntityTransaction transaction = userServiceImpl.getEntityManager().getTransaction();
            transaction.begin();
        }
    }

    @After("execution (* org.geektimes.projects.user.service.UserServiceImpl.register(..))")
    public void afterRegister(JoinPoint point){
        UserServiceImpl userServiceImpl = (UserServiceImpl) point.getThis();
        EntityTransaction transaction = userServiceImpl.getEntityManager().getTransaction();
        transaction.commit();
    }

}
