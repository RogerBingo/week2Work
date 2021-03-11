package org.geektimes.aspectj;

public class TestAspectj {

    public void sayHello(){
        System.out.println("Say Hello!");
    }

    public static void main(String[] args) {
        TestAspectj testAspectj = new TestAspectj();
        testAspectj.sayHello();
    }
}
