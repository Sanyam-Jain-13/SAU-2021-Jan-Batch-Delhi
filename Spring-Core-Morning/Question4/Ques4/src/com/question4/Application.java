package com.question4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {


        //when using AppConfig.class
        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);

        Triangle triangle = (Triangle)factory.getBean("TriangleObj");

        triangle.draw();
        triangle.setType("Scalene");
        triangle.draw();

        System.out.println();

        Rectangle rectangle = (Rectangle)factory.getBean("RectangleObj");
        rectangle.draw();


    }
}
