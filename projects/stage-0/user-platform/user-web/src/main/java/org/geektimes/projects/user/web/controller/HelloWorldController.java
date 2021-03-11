package org.geektimes.projects.user.web.controller;

import org.geektimes.context.ComponentContext;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 输出 “Hello,World” Controller
 */
@Path("/register")
public class HelloWorldController implements PageController {

    @POST
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ComponentContext context = ComponentContext.getInstance();
        UserServiceImpl userService = context.getComponent("bean/UserService");
        User user = new User();
        user.setId(Long.valueOf(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setPhoneNumber(request.getParameter("phoneNumber"));
        if (userService.register(user)) return "index.jsp";
        return "error.jsp";
    }
}
