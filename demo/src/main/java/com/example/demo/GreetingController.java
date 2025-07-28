package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.test.bean.MyBean;
import com.example.demo.test.bean.MyBean2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@Value("${server.port}")
	private String port;

	@Autowired
	private MyBean myBean;
	@Autowired
	private MyBean2 myConditionalBean;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println(myBean.getName());
		System.out.println(myConditionalBean.getName2());
		return new Greeting(counter.incrementAndGet(), String.format(template, name),port);
	}

}