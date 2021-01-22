package com.example;

import com.sun.istack.Nullable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class sanyam {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int sID;
    String favColor;
    String favFood;
//    @Transient
//    @ColumnDefault("-1")
    int age;
//
//    @OneToOne
//    private Alien alien;

    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    @OneToMany
    List<Alien>alienList;
    {
        alienList = new ArrayList<Alien>();
    }

    public sanyam(){}

//    public sanyam(String favColor,String favFood, int age,Alien alien)
//    {
//        this.favColor = favColor;
//        this.favFood = favFood;
//        this.age =  age;
//        this.alien = alien;
//    }

    public sanyam(String favColor, String favFood, int age, List<Alien>alien)
    {
        this.favColor = favColor;
        this.favFood = favFood;
        this.age =  age;
        this.alienList = alien;
    }
//
    public List<Alien> getAlienList() {
        return alienList;
    }

    public void setAlienList(List<Alien> alienList) {
        this.alienList = alienList;
    }
    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getFavColor() {
        return favColor;
    }

    public void setFavColor(String favColor) {
        this.favColor = favColor;
    }

    public String getFavFood() {
        return favFood;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public Alien getAlien() {
//        return alien;
//    }

    @Override
    public String toString() {
        return "sanyam{" +
                "sID=" + sID +
                ", favColor='" + favColor + '\'' +
                ", favFood='" + favFood + '\'' +
                ", age=" + age +
                ", alienList=" + alienList +
                '}';
    }

//    public void setAlien(Alien alien) {
//        this.alien = alien;
//    }

}
