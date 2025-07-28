package com.example.demo.mytest.mybean;

import org.springframework.stereotype.Component;

//@Component
public class Student {
	private String name ;
	private String idNo;
	private Book book;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void sayHello(){
		System.out.println("Hello !!!");
	}
}
