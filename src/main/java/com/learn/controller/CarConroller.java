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
import com.learn.entity.MyCar;
import com.learn.entity.MyWrapper;

@Controller
@RequestMapping("/cars")
public class CarConroller {

	private static int ID=1;
	

	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<MyCar> getCar(@PathVariable int id){
		MyCar car = new MyCar();
	    car.setColor("Blue");
	    car.setMiles(100);
	    car.setVIN("1234");
		return new ResponseEntity<MyCar>(car, HttpStatus.OK);
	}
	
	@RequestMapping(value="/list" , method=RequestMethod.GET)
	public ResponseEntity<List<MyCar>> getCars(){
		MyCar car = new MyCar();
	    car.setColor("Blue");
	    car.setMiles(100);
	    car.setVIN("1234");
	    List<MyCar> carL = new ArrayList<MyCar>();
	    carL.add(car);
	    carL.add(car);
	    carL.add(car);
	    carL.add(car);
	    carL.add(car);
	    carL.add(car);
	    
		return new ResponseEntity<List<MyCar>>(carL, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/addl" , method=RequestMethod.POST)
	public ResponseEntity<List<MyCar>> saveList(@RequestBody List<MyCar> cars){
		List<MyCar> cl = new ArrayList<MyCar>();
		
		for(MyCar c : cars){
			c.setColor("GOLDEN GOLD");	
			cl.add(c);		
		}
		
		return new ResponseEntity<List<MyCar>>(cl, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add" , method=RequestMethod.POST)
	public ResponseEntity<MyCar> save(@RequestBody MyCar car){
		System.out.println("Entered Add Car END-POINT");
		car.setColor("GOLDEN GOLD");
		if(car != null){
			return new ResponseEntity<MyCar>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<MyCar>(car, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ResponseEntity<MyWrapper> updateWrapper(@RequestBody MyWrapper wrap){
		wrap.getCar().get(0).setMiles(-111111);
		wrap.getTruck().setMiles(-111111);
		return new ResponseEntity<MyWrapper>(wrap, HttpStatus.OK);
	}

	
}
