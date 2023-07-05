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

 

import com.cg.grocery.entity.Supplier;
import com.cg.grocery.service.SupplierService;
import com.cg.grocery.service.SupplierServiceImpl;

 

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(SupplierServiceImpl.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)

 


class SupplierServiceImplTest {
    @Autowired
    private SupplierService sservice;
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
    void testAddSuppliers() {
        Supplier sup=new Supplier(61,"Supplier","Hyderbad","parleg");
        sservice.addSupplier(sup);    
    }
    @Test
    void testFindAllSuppliers(){
        List<Supplier>item=sservice.findAllSupplier();
        assertTrue(!item.isEmpty());


    }
}