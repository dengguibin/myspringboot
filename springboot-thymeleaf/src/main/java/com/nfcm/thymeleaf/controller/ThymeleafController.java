package com.nfcm.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nfcm.thymeleaf.entity.User;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeleafController {
	private Logger logger = LoggerFactory.getLogger(ThymeleafController.class);
	@RequestMapping("/home")
	public String hello(Map<String,Object> map){
		System.out.println("jinlailllllllll");
		User user = new User("1", "fei", 22, "爱好：篮球","admin");
		map.put("user",user);
		
		List<User> list = new ArrayList<>();
		for(int i =0;i<5;i++){
			User u = new User(""+(i+2), "fei"+(i+2), 22+(i+2), "爱好：篮球"+(i+2),"user"+i);
			list.add(u);
		}
		map.put("userList",list);
		
		return "home";
	}

	@RequestMapping("/register")
	@ResponseBody
	public String register(){
		return "execute resister";
	}

}
