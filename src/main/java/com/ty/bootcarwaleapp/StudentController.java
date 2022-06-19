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
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/savestudent")
	public String saveStudent(@RequestBody Student student)
	{
		studentRepository.save(student);
		return "Student Saved ";
	}
	@GetMapping("/getallStudent")
	public List<Student> getAllStudent()
	{
		return studentRepository.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id)
	{
		
		Optional<Student> opt = studentRepository.findById(id);
		if(opt.isEmpty())
		{
			return null;
		}
		else
		{
		return opt.get();
		}
	}
	
	@GetMapping("/deleteStudent")
	public  String deleteCarById(@RequestParam int id)
	{
		Optional<Student> opt = studentRepository.findById(id);
		if(opt.isEmpty())
		{
			return "no Student to delete";
		}
		else
		{
			Student student = opt.get();
			studentRepository.delete(student);
			return "Student deleted";
		}
	}
	
	@PostMapping("/updateStudent/{id}")
	public Student updateStudent(@PathVariable int id ,@RequestBody Student student)
	{
		Optional<Student> opt = studentRepository.findById(id);
		if(opt.isEmpty())
		{
			return null;
		}
		else
		{
			
			return studentRepository.save(student);
		}
	}
}
