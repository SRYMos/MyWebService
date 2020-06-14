package com.sry.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sry.entity.SryUser;
import com.sry.service.SryUserService;

@RestController
@RequestMapping(path="/user")
public class WebServiceUserController {
	
	@Autowired
	private SryUserService sryUserService;
	
	@GetMapping
	public String welcome() {
		return "Welcome to web service User.";
	}
	
	@GetMapping("/allUser")
	public List<SryUser> getAllUser() {
		List<SryUser> sryUserList = new ArrayList<SryUser>();
		sryUserList = sryUserService.getAllUser();
		return sryUserList;
	}
	
	@PostMapping("/add")
	public String addUser(@RequestBody List<SryUser> sryUserList) {
		return sryUserService.addUser(sryUserList);
	}

	public void setSryUserService(SryUserService sryUserService) {
		this.sryUserService = sryUserService;
	}
}
