package com.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.entity.User;
import com.learn.service.UserService;

@Controller
@RequestMapping("/users")
public class HelloController {
	
	private static int ID=0;
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/sir", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String sayHello(ModelMap model){
		model.addAttribute("called", "HERE");
		return "list";
	}
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String sayHelloFor(@PathVariable String name){
		return name;
	}
	
	@RequestMapping(value="/add" , method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void addUser(@RequestParam String name, @RequestParam String mobile){
		User u = new User();
		u.setUserName(name);
		u.setMobile(mobile);
		userService.addUser(u);
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User getUser(@PathVariable Integer id){
		User u = userService.getUser(id);
		System.out.println();
		return userService.getUser(id);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody List<User> listUsers(){
		return userService.listUsers();
	}
	
	
	@RequestMapping(value="/delete/{id}")
	public @ResponseBody void deleteUser(@PathVariable Integer id){
		userService.deleteUser(id);
	}
	
	/**
	 * below url is called when the url contains a request parameter P
	 * url/path?P=ANYTHING
	 * @return
	 */
	@RequestMapping(value="/test" , params={"P"})
	public @ResponseBody String withP(){
		return "P";
	}
	
	/**
	 * below url is called when the url contains a request parameter K
	 * url/path?K=ANYTHING
	 * @return
	 */
	@RequestMapping(value="/test" , params={"K"})
	public @ResponseBody String withK(){
		return "K";
	}
	
	
}
