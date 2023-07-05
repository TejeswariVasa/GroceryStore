package com.cg.grocery.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.grocery.controller.GroceryDeliveryController;
import com.cg.grocery.dao.ItemDao;
import com.cg.grocery.dao.OrderrDao;
import com.cg.grocery.entity.ItemDetails;
import com.cg.grocery.entity.Items;
import com.cg.grocery.exception.ItemIdNotFoundException;
import com.cg.grocery.exception.ItemNameNotFoundException;
import com.cg.grocery.exception.UserNotFoundException;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao idao;
	@Autowired
	private OrderrDao odao;

	
	private Logger logger =Logger.getLogger(ItemServiceImpl.class); 

	public boolean add(ItemDetails item) {
//logger.info("Center_Id : "+item.getItemName());
		ItemDetails itemD = idao.save(item);
		logger.info(item);
		return true;
	}

	public boolean addItem(ItemDetails item) {
		idao.save(item);
		logger.info(item);
		return true;
	}

	
	
	@Override
	public List<ItemDetails> findAllItems() {

		List<ItemDetails> list = new ArrayList<>();
		idao.findAll().forEach(list1 -> list.add(list1));
		logger.info(list);
		return list;
	}

	@Override
	public boolean deleteItem(Integer itemId) {
		if (!idao.existsById(itemId)) {
            throw new UserNotFoundException("the item is not found for the entered address id : " + itemId);
		}
		idao.deleteById(itemId);
            return true;
		
		}

//	@Override
//	public String OrderItems(Items item) {
//		Optional<ItemDetails>opt =idao.findById(item.getItemId());
//		 if(!opt.isPresent()) {			
//			 throw new ItemIdNotFoundException("invalid movieid"+item.getItemId());		
//		 }
//		 ItemDetails mDetails = opt.get();
//			if(!mDetails.getItemName().equalsIgnoreCase(item.getItemName()) ){
//				throw new ItemNameNotFoundException("Name is not found: "
//				         +item.getItemName());
//			}
//			int t=item.getPrice();
//		     String totalCost=""+(t*200);
//		     Items itemD = odao.save(item);
//		     logger.info(item);
//		     return "Total amount to be paid :"+totalCost;
//
//	}

	




}
