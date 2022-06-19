package com.ty.bootcarwaleapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/products")
	public String saveProduct(@RequestBody Product product)
	{
		 productRepository.save(product);
		return "Product Saved ";
	}
	@GetMapping("/products")
	public List<Product> getAllProduct()
	{
		return productRepository.findAll();
	}
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id)
	{
		
		Optional<Product> opt = productRepository.findById(id);
		if(opt.isEmpty())
		{
			return null;
		}
		else
		{
		return opt.get();
		}
	}
	@DeleteMapping("/products{id}")
	public  String deleteProductById(@RequestParam int id)
	{
		Optional<Product> opt = productRepository.findById(id);
		if(opt.isEmpty())
		{
			return "no product to delete";
		}
		else
		{
			Product product = opt.get();
			productRepository.delete(product);
			return "Product deleted";
		}
	}
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable int id ,@RequestBody Product product)
	{
		Optional<Product> opt = productRepository.findById(id);
		if(opt.isEmpty())
		{
			return null;
		}
		else
		{
			
			return productRepository.save(product);
		}
	}
}

