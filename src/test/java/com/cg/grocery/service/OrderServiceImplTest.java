package com.cg.grocery.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

 

import javax.persistence.EntityManager;

 

import org.junit.jupiter.api.Test;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order;
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

 

import com.cg.grocery.entity.ItemDetails;
import com.cg.grocery.entity.Items;
import com.cg.grocery.service.OrderService;
import com.cg.grocery.service.OrderServiceimpl;

 


@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(OrderServiceimpl.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class OrderServiceImplTest {
    @Autowired
    private OrderService OService;
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
    void testOrder() {
        Items item=new Items(12,"chocolate",50,5);
        
        // Call the order() method
        String m=OService.OrderItems(item);



        // Assert the result
        assertEquals(item,m);
    }


    }
