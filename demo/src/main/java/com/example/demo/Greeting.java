package com.example.demo;

public class Greeting {

	private final long id;
	private final String content;
	private String port;

	public Greeting(long id, String content,String port) {
		this.id = id;
		this.content = content;
		this.port = port;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}
