package com.question4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Rectangle {

    @Autowired
    @Qualifier("PointA")
    private Point pointA;

    @Autowired
    @Qualifier("PointB")
    private Point pointB;

    @Autowired
    @Qualifier("PointC")
    private Point pointC;

    @Autowired
    @Qualifier("PointD")
    private Point pointD;

    public Rectangle(){}

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
    }

    public void draw(){

        String drawing = "Rectangle{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", pointD=" + pointD +
                '}';
        System.out.println(drawing);

    }

}
