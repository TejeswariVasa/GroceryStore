package com.cg.grocery.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.grocery.controller.GroceryDeliveryController;
import com.cg.grocery.dao.UserDao;
import com.cg.grocery.entity.UserDetails;
import com.cg.grocery.exception.AuthenticationFailedException;
import com.cg.grocery.exception.InvalidUserRoleException;
import com.cg.grocery.exception.UserAlreadyExistException;

@Service
@Transactional
public class UserServiceImpl  implements UserService{
    @Autowired
    private UserDao uDao;
    
	private Logger logger =Logger.getLogger(UserServiceImpl.class); 


    @Override
    public UserDetails login(UserDetails userDetails) {
        System.out.println(uDao);
        String role = "";
        //Optional<UserDetails> op = uDao.findById(userDetails.getUserId());
        UserDetails userDb = uDao.findByName(userDetails.getUserName());
        if(userDb==null){
			logger.error("user not found by name :" +userDetails.getUserName());

            throw new AuthenticationFailedException("No User found for username= "+userDetails.getUserName());
        }
        if(!userDetails.getPassword().equals(userDb.getPassword())) {
			logger.error("authentication failed :" +userDetails.getPassword());;

            throw new AuthenticationFailedException("Authentication failed for username= ");
        }
        return userDb ;
    }
    @Override
    public boolean add(UserDetails user) {
        if(uDao.existsById(user.getUserId())) {
            throw new UserAlreadyExistException("You have already registered to Grocery Delivery Application. please log in");
        }
        if (user.getUserRole().equalsIgnoreCase("Admin")
                ||user.getUserRole().equalsIgnoreCase("customer")) {
                uDao.save(user);
        }
        else {
            throw new InvalidUserRoleException("Invalid UserRole");
        }
        logger.info(user);
        return true;
    }
    

}
