package com.cg.grocery.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.grocery.dto.CreateDistributorRequest;
import com.cg.grocery.dto.CreateSupplierRequest;
import com.cg.grocery.entity.Distributor;
import com.cg.grocery.entity.Supplier;
import com.cg.grocery.exception.AuthorizedUserRoleNotFoundException;
import com.cg.grocery.exception.NotLoggedInException;
import com.cg.grocery.service.SupplierService;

@RestController
@RequestMapping("SupplierController")
public class SupplierController {
	@Autowired
         private SupplierService sservice;
	private Logger logger =Logger.getLogger(SupplierController.class); 
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add_supplier")
	public String addSupplier(HttpServletRequest request, @RequestBody CreateSupplierRequest requestData)
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
		Supplier supplier = new Supplier(requestData.getSid(),requestData.getSname(),requestData.getLocation(),requestData.getCompany());
		Supplier supplier1= null;
		if (sservice.addSupplier(supplier)) {
			logger.info("Supplier added");
			return "supplier added";
			
		}
		logger.error("Supplier not added");
		return "Supplier not added";

	}
	@GetMapping("/findall/Supplier")
	List<Supplier> findAllSupplier(HttpServletRequest request){
	    List<Supplier> si = new ArrayList<Supplier>();
	    si=sservice.findAllSupplier();
	    return si;
	    
	    }


	

}
