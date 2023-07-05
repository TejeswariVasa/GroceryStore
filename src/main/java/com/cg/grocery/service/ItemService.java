package com.cg.grocery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.grocery.entity.ItemDetails;
import com.cg.grocery.entity.Items;

@Service
public interface ItemService {
	boolean addItem(ItemDetails item) ;


	List<ItemDetails> findAllItems();


	boolean deleteItem(Integer itemId);

//	String OrderItems(Items item);




}
