package com.springMapSet;

import java.util.Map;
import java.util.Set;

public class SetMap {

    private int id;

    private Map<Integer, String> mapObj;

    private Set<Integer> setObj;

    private Set<Point> setOfPoints;

    private Map<String, Point> mapOfPoint;

    public SetMap() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, String> getMapObj() {
        return mapObj;
    }
    public void setMapObj(Map<Integer, String> mapObj) {
        this.mapObj = mapObj;
    }

    public Set<Integer> getSetObj() {
        return setObj;
    }
    public void setSetObj(Set<Integer> setObj) {
        this.setObj = setObj;
    }

    public Set<Point> getSetOfPoints() { return setOfPoints; }
    public void setSetOfPoints(Set<Point> setOfPoints) { this.setOfPoints = setOfPoints; }

    public Map<String, Point> getMapOfPoint() { return mapOfPoint; }

    public void setMapOfPoint(Map<String, Point> mapOfPoint) { this.mapOfPoint = mapOfPoint; }

    void display(){
        System.out.println("\nId: "+this.getId());

        System.out.println("\nMap Object:");
        for (Map.Entry<Integer, String> entry : this.getMapObj().entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        System.out.println("\nMap of Points:");
        for (Map.Entry<String, Point> entry : this.getMapOfPoint().entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        System.out.println("\nSet Object:");
        System.out.println(this.getSetObj());

        System.out.println("\nSet of Points:");
        System.out.println(this.getSetOfPoints());

    }
}
