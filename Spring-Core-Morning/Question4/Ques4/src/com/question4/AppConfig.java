package com.question4;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name="TriangleObj")
    public Triangle getTriangle() {
        return new Triangle("Equilateral",10, 20);
    }

    @Bean(name="RectangleObj")
    public Rectangle getRectangle() {
        return new Rectangle();
    }

    @Bean(name="PointA")
    public Point getPointObjA() {
        return new Point(10,20);
    }

    @Bean(name="PointB")
    public Point getPointObjB() {
        return new Point(11,22);
    }

    @Bean(name="PointC")
    public Point getPointObjC() {
        return new Point(31,32);
    }

    @Bean(name="PointD")
    public Point getPointObjD() {
        return new Point(41,12);
    }

}

