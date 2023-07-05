package com.cg.grocery.service;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.grocery.dao.UserDao;
import com.cg.grocery.entity.UserDetails;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(UserServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class UserServiceTest {
	@Autowired
	private UserServiceImpl uService;
	@Autowired
    private UserDao uDao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
	}
	@Test
	void testLogin() {
		UserDetails userLogin = new UserDetails("priya","priya");
		UserDetails userDb = uDao.findByName(userLogin.getUserName());
        UserDetails log = uService.login(userLogin);
        assertEquals(userDb,log);
	}
	@Test
	void testAdd() {
		UserDetails det = new UserDetails(20, "preethi","preethi123","admin");
        boolean centerName = uService.add(det);
        assertEquals(true,centerName);
	}
}
