package com.au.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.au.aop.service.ShapeService;

public class AopMain {
	
	public static void main(String[] args){
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeservice", ShapeService.class);

		shapeService.getCircle().setName("Circle1");
		System.out.println(shapeService.getCircle().getName());
		try {
			shapeService.getTriangle().setName("");
			System.out.println(shapeService.getTriangle().getName());
		}
		catch (Exception e){
			System.out.println("Exception on Triangle");
		}
	}

}
