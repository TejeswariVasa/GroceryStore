package com.cg.grocery.service;

import org.springframework.stereotype.Service;

import com.cg.grocery.entity.UserDetails;

@Service
public interface UserService {
	UserDetails login(UserDetails userDetails);

	boolean add(UserDetails userdetails);


}
