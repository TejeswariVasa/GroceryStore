package com.cg.grocery.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

 

import java.time.LocalDate;
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

 

import com.cg.grocery.entity.ItemDetails;
import com.cg.grocery.service.ItemService;
import com.cg.grocery.service.ItemServiceImpl;

 

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(ItemServiceImpl.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class ItemServiceImplTest {
    @Autowired
    private ItemService IService;
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
        ItemDetails item=new ItemDetails(12,"Sugar",50,5);
        IService.addItem(item);

    }
    @Test
    void testFindAllItems(){
        List<ItemDetails>item=IService.findAllItems();
        assertTrue(!item.isEmpty());


    }
    @Test
    void testDeleteItem() {
        fail("Not yet Implemented");
    }
}