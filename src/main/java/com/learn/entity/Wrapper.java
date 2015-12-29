package com.learn.entity;

import java.util.List;

public class Wrapper {
List<Car> car;
Truck truck;
public List<Car> getCar() {
	return car;
}
public void setCar(List<Car> car) {
	this.car = car;
}
public Truck getTruck() {
	return truck;
}
public void setTruck(Truck truck) {
	this.truck = truck;
}
}
