package com.hardik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hardik.models.User;
import com.hardik.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value={"/","/home"})
	public String adminHome(Model model)
	{
		model.addAttribute("users",userService.findAll());
		return "adminHome";
	}
	
	@GetMapping("/edit")
	public String adminEdit(@RequestParam("userId")int userId,Model model)
	{
		User user= userService.findByUserId(userId);
		System.out.println(user.getUserId());
		model.addAttribute("user",user);
		return "adminEdit";
	}
	
	@PostMapping("/edit")
	public String adminEditPost(@ModelAttribute("user")User user)
	{
		System.out.println("AdminController"+user.getUserId());
		userService.update(user);
		return "redirect:/admin/home";
	}
	
	@GetMapping("/delete/{id}")
	public String adminDelete(@PathVariable("id")int userId )
	{
		userService.delete(userId);
		return "redirect:/admin/home";
		
	}
	@RequestMapping("/logout-success")
	public String logout()
	{
		return "redirect:/login";
	}
}
