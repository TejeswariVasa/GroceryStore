package com.cg.grocery.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.grocery.dao.ItemDao;
import com.cg.grocery.dao.OrderrDao;
import com.cg.grocery.entity.ItemDetails;
import com.cg.grocery.entity.Items;
import com.cg.grocery.exception.ItemIdNotFoundException;
import com.cg.grocery.exception.ItemNameNotFoundException;
@Service
@Transactional


public class OrderServiceimpl implements OrderService {
	@Autowired
	private ItemDao idao;
	@Autowired
	private OrderrDao odao;
	private Logger logger =Logger.getLogger(OrderServiceimpl.class); 



	@Override
	public String OrderItems(Items item) {
		Optional<ItemDetails>opt =idao.findById(item.getItemId());
		 if(!opt.isPresent()) {			
			 throw new ItemIdNotFoundException("invalid itemid"+item.getItemId());		
		 }
		 ItemDetails mDetails = opt.get();
			if(!mDetails.getItemName().equalsIgnoreCase(item.getItemName()) ){
				throw new ItemNameNotFoundException("Name is not found: "
				         +item.getItemName());
			}
			Items i=odao.save(item);
			
			
			return "Order is successfull";
//			int t=item.getPrice();
//		     String totalCost=""+(t*t);
//		     Items itemD = odao.save(item);
//		     logger.info(item);
//		     return "Total amount to be paid :"+totalCost;
//

	}
	

}
