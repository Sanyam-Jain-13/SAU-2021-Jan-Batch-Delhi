package com.question4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//@Component
//@Scope(value = "prototype")
public class Triangle {


    private String type;
    private int width;
    private int height;

    @Autowired
    @Qualifier("PointA")
    private Point pointA;

    @Autowired
    @Qualifier("PointB")
    private Point pointB;

    @Autowired
    @Qualifier("PointC")
    private Point pointC;


    //Add Non-Primitive type member variable

    public Triangle(){}

    public Triangle(String type, int width, int height) {
        this.type = type;
        this.width = width;
        this.height = height;
    }

    public String getType() { return type; }
    public void setType(String type) {//setter injection
        this.type = type;
    }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

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

    public Point getPointC() { return pointC; }

    public void setPointC(Point pointC) { this.pointC = pointC; }

    public void draw() {
        String drawing = "Triangle{" +
                "type='" + type + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                '}';
        System.out.println(drawing);
    }

}
