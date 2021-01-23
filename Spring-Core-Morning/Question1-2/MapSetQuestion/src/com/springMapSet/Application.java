package com.springMapSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Application {

    public static void main(String[] args) throws Exception{

        ApplicationContext factory = new FileSystemXmlApplicationContext("src/spring.xml");

        SetMap setmapObj = (SetMap) factory.getBean("setmap");
        setmapObj.display();

    }
}
