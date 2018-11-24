package com.wisely.ch8_5.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.ch8_5.domain.Person;
import com.wisely.ch8_5.service.DemoService;

@RestController
public class CacheController {
	
	@Autowired
	DemoService demoService;
	
	@RequestMapping("/put")
	public Person put(Person person) {
		return demoService.save(person);
	}
	
	@RequestMapping("/able")	//Q:这里为什么在url里输入/able?id=1会去查找id为1的person，没有@param之类的注解？
	public Person cacheable(Person person) {
		return demoService.findOne(person);
	}
	
	@RequestMapping("/evit")
	public String evit(Long id) {
		demoService.remove(id);
		return "ok";
	}
	
	@RequestMapping("/test")
	public String test(Integer param1, Integer param2) {
		return String.valueOf(param1 + param2);
	}
}
