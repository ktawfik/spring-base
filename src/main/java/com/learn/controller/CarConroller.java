package com.learn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learn.entity.Car;
import com.learn.entity.Wrapper;


@Controller
@RequestMapping("/cars")
public class CarConroller {

	private static int ID=1;
	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<Car> getCar(@PathVariable int id){
		Car car = new Car();
	    car.setColor("Blue");
	    car.setMiles(100);
	    car.setVIN("1234");
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	
	@RequestMapping(value="/list" , method=RequestMethod.GET)
	public ResponseEntity<List<Car>> getCars(){
		Car car = new Car();
	    car.setColor("Blue");
	    car.setMiles(100);
	    car.setVIN("1234");
	    List<Car> carL = new ArrayList<Car>();
	    carL.add(car);
	    carL.add(car);
	    carL.add(car);
	    carL.add(car);
	    carL.add(car);
	    carL.add(car);
	    
		return new ResponseEntity<List<Car>>(carL, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/addl" , method=RequestMethod.POST)
	public ResponseEntity<List<Car>> saveList(@RequestBody List<Car> cars){
		List<Car> cl = new ArrayList<Car>();
		
		for(Car c : cars){
			c.setColor("GOLDEN GOLD");	
			cl.add(c);		
		}
		
		return new ResponseEntity<List<Car>>(cl, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add" , method=RequestMethod.POST)
	public ResponseEntity<Car> save(@RequestBody Car car){
		System.out.println("Entered Add Car END-POINT");
		car.setColor("GOLDEN GOLD");
		
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ResponseEntity<Wrapper> updateWrapper(@RequestBody Wrapper wrap){
		wrap.getCar().get(0).setMiles(-111111);
		wrap.getTruck().setMiles(-111111);
		return new ResponseEntity<Wrapper>(wrap, HttpStatus.OK);
	}
	
	
}
