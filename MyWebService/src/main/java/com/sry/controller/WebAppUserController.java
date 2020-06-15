package com.sry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sry.service.SryUserService;

@Controller
@RequestMapping(path="/sry")
public class WebAppUserController {
	@Autowired
	private SryUserService sryUserService;
	
	@GetMapping("/user/list")
	public String getAllUser(Model model) {
		model.addAttribute("users",sryUserService.getAllUser());
		return "listUser";
	}
	
	@GetMapping("/user/{id}")
	public String getUser(@PathVariable int id,Model model) {
		model.addAttribute("user",sryUserService.getUserById(id));
		return "user";
	}
}
