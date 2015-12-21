package com.learn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value="/sir", method=RequestMethod.GET)
	public ResponseEntity<User> sayHello(){
		//model.addAttribute("called", "HERE");
		User u = new User();
		u.setUserName("Karim");
		u.setMobile("0122222222");
		return new ResponseEntity<User>(u, HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User sayHelloFor(@PathVariable String name){
		User u = new User();
		u.setUserName("Karim");
		u.setMobile("0122222222");
		return u;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<User> update(@RequestBody User user) {
		System.out.println("Entered Updates");
		if (user != null) {
			user.setMobile("No Mobile .....");
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
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
	public ResponseEntity<List<User>> listUsers(){
		System.out.println("===============Will Enter");
		User u = new User();
		u.setUserName("Karim");
		u.setMobile("0122222222");
		List<User> l = new ArrayList<User>();
		l.add(u);
		l.add(u);
		l.add(u);
		l.add(u);
		l.add(u);
		l.add(u);
		l.add(u);
		l.add(u);
		l.add(u);
		System.out.println("================Will return");
		return new ResponseEntity<List<User>>(l, HttpStatus.OK);
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
