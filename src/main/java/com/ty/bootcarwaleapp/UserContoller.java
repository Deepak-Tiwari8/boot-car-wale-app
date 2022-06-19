package com.ty.bootcarwaleapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserContoller {

	@Autowired
	UserRepository userRepository;
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody User user)
	{
		 userRepository.save(user);
		return "User Saved ";
	}
	@GetMapping("/getallUser")
	public List<User> getAllUser()
	{
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id)
	{
		
		Optional<User> opt = userRepository.findById(id);
		if(opt.isEmpty())
		{
			return null;
		}
		else
		{
		return opt.get();
		}
	}
	
	@GetMapping("/deleteUser")
	public  String deleteUserById(@RequestParam int id)
	{
		Optional<User> opt = userRepository.findById(id);
		if(opt.isEmpty())
		{
			return "no User to delete";
		}
		else
		{
			User user = opt.get();
			userRepository.delete(user);
			return "User deleted";
		}
	}
	
	@PostMapping("/updateUser/{id}")
	public User updateUser(@PathVariable int id ,@RequestBody User user)
	{
		Optional<User> opt = userRepository.findById(id);
		if(opt.isEmpty())
		{
			return null;
		}
		else
		{
			
			return userRepository.save(user);
		}
	}
	@GetMapping("/userEmail")
	public List<User> getUserByEmail(@RequestParam String email)
	{
      return userRepository.findByEmail(email);
	}
	
	@GetMapping("/userrole")
	public List<User> getUserByRole(@RequestParam String role)
	{
      return userRepository.findByEmail(role);
	}
	
	@GetMapping("/userpassword")
	public List<User> getUserByPassword(@RequestParam String password)
	{
      return userRepository.findByEmail(password);
	}
	@GetMapping("/userGenderRole/{gender}/{role}")
	public List<User> getData(@PathVariable String gender,@PathVariable String role)
	{
		return  userRepository.getData(gender, role);
	}
	
	@GetMapping("/UserEmailAndPassword")
	public List<User> validate(@RequestParam String email,@RequestParam String password)
	{
		return userRepository.validate(email, password);
	}

}
