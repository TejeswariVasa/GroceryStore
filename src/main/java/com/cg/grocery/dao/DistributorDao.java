package com.cg.grocery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.grocery.entity.Distributor;
import com.cg.grocery.entity.ItemDetails;


@Repository
public interface DistributorDao  extends JpaRepository<Distributor, Integer>{

}
