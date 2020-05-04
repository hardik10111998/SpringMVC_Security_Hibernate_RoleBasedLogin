package com.hardik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hardik.models.User;
import com.hardik.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/home")
	public String userHome(Model model)
	{
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		String userName= auth.getName();
		System.out.println("userName="+userName);
		User user= userService.findByUserName(userName);
		model.addAttribute("user",user);
		return "userHome";
		
	}
	@RequestMapping("/edit")
	public String userEdit(@RequestParam("userId")int userId,Model model)
	{
		model.addAttribute("user", userService.findByUserId(userId));
		return "userEdit";
	}
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String userEdited(@ModelAttribute("user")User user)
	{
		userService.update(user);
		return "redirect:/user/home";
	}
}
