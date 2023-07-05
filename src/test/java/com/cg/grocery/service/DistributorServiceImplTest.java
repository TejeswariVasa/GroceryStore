package com.cg.grocery.service;

import static org.junit.Assert.assertTrue;



import java.util.List;

 

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

 

import com.cg.grocery.entity.Distributor;
import com.cg.grocery.entity.ItemDetails;
import com.cg.grocery.service.DistributorService;
import com.cg.grocery.service.DistributorServiceImpl;
import com.cg.grocery.service.ItemService;

 

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(DistributorServiceImpl.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)

 


class DistributorServiceImplTest {
    @Autowired
    private DistributorService DService;
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
    void testAddDistributor() {
        Distributor dis=new Distributor(51,"Distributor","Bangalore","Lays");
        DService.addDistributor(dis);    
    }
    @Test
    void testFindAllDistributors(){
        List<Distributor>item=DService.findAllDistributors();
        assertTrue(!item.isEmpty());


    }

 


}