package com.cg.grocery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.grocery.entity.Supplier;


@Service
public interface SupplierService {

	boolean addSupplier(Supplier supplier);

	List<Supplier> findAllSupplier();

}
