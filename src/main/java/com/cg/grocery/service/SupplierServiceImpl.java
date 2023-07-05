package com.cg.grocery.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.grocery.dao.SupplierDao;

import com.cg.grocery.entity.Supplier;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService{
	@Autowired
	private SupplierDao sdao;
	private Logger logger =Logger.getLogger(SupplierServiceImpl.class);
	@Override
	public boolean addSupplier(Supplier supplier) {
		Supplier s = sdao.save(supplier);
		logger.info(supplier);

		return true;
	}
	@Override
	public List<Supplier> findAllSupplier() {
		List<Supplier> list = new ArrayList<>();
		sdao.findAll().forEach(list1 -> list.add(list1));
		logger.info(list);
		return list;
} 



		
}
