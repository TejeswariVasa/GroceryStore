package com.cg.grocery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.grocery.entity.Distributor;
@Service
public interface DistributorService {

	boolean addDistributor(Distributor distributor);

	List<Distributor> findAllDistributors();


}
