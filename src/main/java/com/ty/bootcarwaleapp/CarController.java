package com.ty.bootcarwaleapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	@Autowired
	CarRepository ref;
	
	@PostMapping("/savecar")
	public String saveCar(@RequestBody Car car)
	{
		ref.save(car);
		return "Car Saved ";
	}
	
	@GetMapping("/getallCar")
	public List<Car> getAllCar()
	{
		return ref.findAll();
	}
	
	@GetMapping("/Car/{id}")
	public Car getCarById(@PathVariable int id)
	{
		
		Optional<Car> opt = ref.findById(id);
		if(opt.isEmpty())
		{
			return null;
		}
		else
		{
		return opt.get();
		}
	}
	
	@GetMapping("/deletecar")
	public  String deleteCarById(@RequestParam int id)
	{
		Optional<Car> opt = ref.findById(id);
		if(opt.isEmpty())
		{
			return "no car to delete";
		}
		else
		{
			Car car = opt.get();
			ref.delete(car);
			return "car deleted";
		}
	}
	
	@PostMapping("/updatecar/{id}")
	public Car updateCar(@PathVariable int id ,@RequestBody Car car)
	{
		Optional<Car> opt = ref.findById(id);
		if(opt.isEmpty())
		{
			return null;
		}
		else
		{
			
			return ref.save(car);
		}
	}
}
