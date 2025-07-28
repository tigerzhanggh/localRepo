package com.example.demo.mytest;

import com.example.demo.mytest.mybean.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotationConfigApplicationContext {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext("com.example.demo.mytest.mybean");
		Student student = context.getBean(Student.class);
		student.sayHello();
	}
}
