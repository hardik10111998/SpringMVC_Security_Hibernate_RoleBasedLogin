package com.hardik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hardik.models.User;
import com.hardik.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value={"/","/login"})
	public String login(Model model){
		String name="Hardik Prajapati";
		model.addAttribute("name", name);
		return "login";
	}

//	@GetMapping("/")
//	  public String index(Model model, Principal principal) {
//		System.out.println(principal.getName());
//		String name=principal.getName();
//	    model.addAttribute("name", name);
//	    return "index";
//	}
//	@RequestMapping(value="/sample", method=RequestMethod.GET)
//	public String sample()
//	{
//		return "sample";
//	}
	
	@RequestMapping("/logout-success")
	public String logout()
	{
		System.out.println("logout");
		return "logout-success";
	}
	@RequestMapping(value="/registration",method=RequestMethod.GET)
	public String register()
	{
		return "registration";
	}
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String postRegister(@ModelAttribute("user")User user)
	{
		userService.save(user);
		return "login";
	}
}
