package com.cg.grocery.controller;

import java.util.ArrayList;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.grocery.dto.CreateDistributorRequest;
import com.cg.grocery.dto.CreateItemResponse;
import com.cg.grocery.dto.CreateOrderRequest;
import com.cg.grocery.dto.OrderDetails;
import com.cg.grocery.dto.UserResponse;
import com.cg.grocery.entity.ItemDetails;
import com.cg.grocery.entity.Items;
import com.cg.grocery.entity.UserDetails;
import com.cg.grocery.exception.AuthorizedUserRoleNotFoundException;
import com.cg.grocery.exception.NotLoggedInException;
import com.cg.grocery.exception.UserNotFoundException;import com.cg.grocery.service.ItemService;
import com.cg.grocery.service.UserService;
import com.cg.grocery.util.ItemUtil;
import com.cg.grocery.util.JwtTokenUtil;



@RestController
@RequestMapping("GroceryController")
//@CrossOrigin("http://localhost:4200")
public class GroceryDeliveryController {
	@Autowired
	private UserService uService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private ItemService IService;
	@Autowired
	private ItemUtil IUtil;


	private Logger logger =Logger.getLogger(GroceryDeliveryController.class); 

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/register")
	public String registeruser(HttpServletRequest request, @RequestBody UserDetails requestData) {
		// UserReasponse user = null;
		boolean newuser = true;
		UserDetails userdetails = new UserDetails(requestData.getUserId(), requestData.getPassword(),
				requestData.getUserName(), requestData.getUserRole());
		if(newuser = uService.add(userdetails)) {
			logger.info("user added");
		
		// user = diagnosticUtil.toDetails1(ud);
		return "User added Successfully";
		}
		logger.error("Failed to register");
		return "User is not added";
	}

	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping("/login")
	public UserResponse login(@RequestParam String user, @RequestParam String password, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(session);
		UserDetails userDb = uService.login(new UserDetails(user, password));
		System.out.println(userDb.toString());
		// session.setAttribute("userid", userDb.getUserId());
		session.setAttribute("username", userDb.getUserName());
		session.setAttribute("role", userDb.getUserRole());
		session.setAttribute("password", userDb.getPassword());
		String token = jwtTokenUtil.generateToken(String.valueOf(userDb.getUserId()), userDb.getUserName(),
				userDb.getUserRole());
		System.out.println(token.toString());
		UserResponse response = new UserResponse();
		response.setToken(token);
		response.setUserId(userDb.getUserId());
		response.setUserName(userDb.getUserName());
		response.setUserRole(userDb.getUserRole());
		ResponseEntity<UserResponse> resEntity = new ResponseEntity<UserResponse>(response, HttpStatus.OK);

		logger.info("logged in");

		return response;
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/logout")
	public String logout(@RequestBody UserDetails userDetails, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("username");
		if (userName == null) {
			throw new NotLoggedInException("You have not logged in");
		} else {
			if (userName.equals(userDetails.getUserName())) {
				session.invalidate();
			}
		}
		logger.error("failed to logout");

		return "You have successfully logged out ";
	}


	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add_Item")
	public String addItem(HttpServletRequest request, @RequestBody CreateItemResponse requestData)
			throws AuthorizedUserRoleNotFoundException, NotLoggedInException {
	    String userName = (String) request.getSession().getAttribute("username");
	    System.out.println(userName);
	    if (userName == null) {
	        throw new NotLoggedInException("You have not logged in");
	    }
	    String userRole = (String) request.getSession().getAttribute("role");
	    if (!userRole.equalsIgnoreCase("Admin")) {
	        throw new AuthorizedUserRoleNotFoundException("you are not authorized to add the item");
	    }

		@SuppressWarnings("unused")
		ItemDetails add = new ItemDetails(requestData.getItemId(),requestData.getItemName(), requestData.getPrice(), requestData.getQuantity());
		ItemDetails item = null;
		if (IService.addItem(add)) {
			logger.info("item added");
			return "item added";
			
		}
		logger.error("item not added");
		return "Item not added";

	}
	@DeleteMapping("/deleteItem/{iId}")
    public String delete(@PathVariable ("iId")  Integer itemId ,HttpServletRequest request) throws NotLoggedInException, AuthorizedUserRoleNotFoundException {

        String userName = (String) request.getSession().getAttribute("username");
        System.out.println(userName);
        if (userName == null) {
            throw new NotLoggedInException("You have not logged in");
        }
        String userRole = (String) request.getSession().getAttribute("role");
        if (!userRole.equalsIgnoreCase("Admin")) {
            throw new AuthorizedUserRoleNotFoundException("you are not authorized to delete the Item");
        }
        if(IService.deleteItem(itemId)) {
        return "Item deleted";

 

        }
            return "Item not deleted";

 

        }
	@GetMapping("/findall/item")
	List<ItemDetails> findAllCustomers(HttpServletRequest request){
	    List<ItemDetails> li = new ArrayList<ItemDetails>();
	    li=IService.findAllItems();
	    return li;
	    
	    }
	
}
