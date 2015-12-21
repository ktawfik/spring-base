package com.learn.entity;

import java.util.List;

public class MyWrapper {
List<MyCar> car;
Truck truck;
public List<MyCar> getCar() {
	return car;
}
public void setCar(List<MyCar> car) {
	this.car = car;
}
public Truck getTruck() {
	return truck;
}
public void setTruck(Truck truck) {
	this.truck = truck;
}
}
