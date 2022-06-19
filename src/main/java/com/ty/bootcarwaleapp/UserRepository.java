package com.ty.bootcarwaleapp;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer>
{

	List<User> findByEmail(String email);
	List<User> findByRole(String role);
	List<User> findByPassword(String password);
	 
	@Query("Select u FROM User u WHERE u.gender=?1 AND u.role=?2")
	List<User> getData(String gender , String role);

	@Query("Select u from User u where u.email=:myemail And u.password=:mypassword")
	List<User> validate(@Param("myemail")String email,@Param("mypassword") String password);
}
