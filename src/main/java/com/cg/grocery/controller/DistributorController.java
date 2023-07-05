package com.cg.grocery.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cg.grocery.dto.CreateDistributorRequest;
import com.cg.grocery.dto.CreateItemResponse;
import com.cg.grocery.entity.Distributor;
import com.cg.grocery.entity.ItemDetails;
import com.cg.grocery.exception.AuthorizedUserRoleNotFoundException;
import com.cg.grocery.exception.NotLoggedInException;
import com.cg.grocery.service.DistributorService;

@RestController
@RequestMapping("DistributorController")

public class DistributorController {
	@Autowired
	private DistributorService Dservice;
	private Logger logger =Logger.getLogger(DistributorController.class); 
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add_distributor")
	public String addDistributor(HttpServletRequest request, @RequestBody CreateDistributorRequest requestData)
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
		Distributor distributor = new Distributor(requestData.getDid(),requestData.getDname(),requestData.getLocation(),requestData.getCompany());
		Distributor distributor1 = null;
		if (Dservice.addDistributor(distributor)) {
			logger.info("distributor added");
			return "distributor added";
			
		}
		logger.error("distributor not added");
		return "distributor not added";

	}
	@GetMapping("/findall/Distributors")
	List<Distributor> findAllDistributors(HttpServletRequest request){
	    List<Distributor> di = new ArrayList<Distributor>();
	    di=Dservice.findAllDistributors();
	    return di;
	    
	    }




}
