package com.cg.grocery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.grocery.entity.UserDetails;

@Repository

public interface UserDao  extends JpaRepository<UserDetails, Integer>   {
	@Query(value = "select u from UserDetails u where u.userName=?1")
	UserDetails findByName(String userName);
}
