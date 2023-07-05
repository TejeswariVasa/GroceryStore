package com.cg.grocery.service;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

 

import com.cg.grocery.entity.Items;
import com.cg.grocery.entity.UserDetails;
import com.cg.grocery.service.UserService;
import com.cg.grocery.service.UserServiceImpl;

 

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(UserServiceImpl.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)

 

class UserServiceImplTest {
    @Autowired
    private UserService uService;
    @Autowired
    private EntityManager eManager;
    @BeforeAll
    static void setupBeforeClass() throws Exception {    
    }
    @AfterAll
    static void tearDownAfterClass() throws Exception {
    } 
    @BeforeEach
    void setUp() throws Exception{

    }
    @AfterEach
    void tearDown() throws Exception{

    }
    @Test
    void testAdd() {
    	UserDetails userDetails = new UserDetails(20, "bharathi","bharathi123","admin");
       
        // Call the add() method
        boolean result = uService.add(userDetails);

        // Assert the result
        assertTrue(result);
    }
 

}