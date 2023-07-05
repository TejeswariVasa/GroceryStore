package com.cg.grocery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.grocery.dto.CreateOrderRequest;
import com.cg.grocery.dto.OrderDetails;
import com.cg.grocery.entity.Items;
import com.cg.grocery.exception.AuthorizedUserRoleNotFoundException;
import com.cg.grocery.exception.NotLoggedInException;
import com.cg.grocery.service.OrderService;
import com.cg.grocery.service.UserService;

@RestController
@RequestMapping("OrderController")
public class OrderController {
	private Logger logger =Logger.getLogger(OrderController.class); 

	@Autowired
	private OrderService OService;
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/customer/orderitems")
	private String OrderItems(@RequestBody CreateOrderRequest requestData,HttpServletRequest request ) {
		HttpSession session = request.getSession();
		String userName = (String) request.getSession().getAttribute("username");
	    System.out.println(userName);
	    if (userName == null) {
	        throw new NotLoggedInException("You have not logged in");
	    }
	    String userRole = (String) request.getSession().getAttribute("role");
	    if (!userRole.equalsIgnoreCase("customer")) {
	        throw new AuthorizedUserRoleNotFoundException("you are not authorized to add the item");
	    }
	  OrderDetails details=null;
	Items item=new Items(requestData.getItemId(),requestData.getItemName(),requestData.getPrice(),requestData.getQuantity());
	Object c=session.getAttribute("user");
	System.out.println("+obj"+c);
	//if(c==null) {
//		throw new UserNotFoundException("You are not logged in") ;
//			
//		}
		String m=OService.OrderItems(item);
		logger.info("Product ordered succesfully");

		return m;
		
	}


}
