package com.cg.grocery.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.grocery.dao.DistributorDao;
import com.cg.grocery.entity.Distributor;
import com.cg.grocery.entity.ItemDetails;
import com.cg.grocery.exception.UserNotFoundException;
@Service
@Transactional


public class DistributorServiceImpl  implements DistributorService{
	@Autowired
	private DistributorDao ddao;
	private Logger logger =Logger.getLogger(DistributorServiceImpl.class); 


	@Override
	public boolean addDistributor(Distributor distributor) {
		Distributor d = ddao.save(distributor);
		logger.info(distributor);
		return true;
	
	}


	@Override
	public List<Distributor> findAllDistributors() {
		List<Distributor> list = new ArrayList<>();
		ddao.findAll().forEach(list1 -> list.add(list1));
		logger.info(list);
		return list;
	}



}
