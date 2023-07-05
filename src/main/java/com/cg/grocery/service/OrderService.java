package com.cg.grocery.service;

import org.springframework.stereotype.Service;

import com.cg.grocery.entity.Items;

@Service
public interface OrderService {

	String OrderItems(Items item);

}
