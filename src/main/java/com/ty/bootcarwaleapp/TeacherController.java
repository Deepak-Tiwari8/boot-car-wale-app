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
public class TeacherController {

	@Autowired
	TeacherRepository  teacherRepository ;
	
	@PostMapping("/saveTeacher")
	public String saveTeacher(@RequestBody Teacher teacher)
	{
		teacherRepository.save(teacher);
		return "Teacher Saved ";
	}
	@GetMapping("/getallTeacher")
	public List<Teacher> getAllTeacher()
	{
		return teacherRepository.findAll();
	}
	
	@GetMapping("/teacher/{id}")
	public Teacher getTeacherById(@PathVariable int id)
	{
		
		Optional<Teacher> opt = teacherRepository.findById(id);
		if(opt.isEmpty())
		{
			return null;
		}
		else
		{
		return opt.get();
		}
	}
	
	@GetMapping("/deleteTeacher")
	public  String deleteTeacherById(@RequestParam int id)
	{
		Optional<Teacher> opt = teacherRepository.findById(id);
		if(opt.isEmpty())
		{
			return "no Teacher to delete";
		}
		else
		{
			Teacher teacher = opt.get();
			teacherRepository.delete(teacher);
			return "Teacher deleted";
		}
	}
	
	@PostMapping("/updateTeacher/{id}")
	public Teacher updateTeacher(@PathVariable int id ,@RequestBody Teacher teacher)
	{
		Optional<Teacher> opt = teacherRepository.findById(id);
		if(opt.isEmpty())
		{
			return null;
		}
		else
		{
			
			return teacherRepository.save(teacher);
		}
	}
	
}
