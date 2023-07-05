package com.cg.grocery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.grocery.entity.ItemDetails;
import com.cg.grocery.entity.Items;

@Repository
public interface ItemDao  extends JpaRepository<ItemDetails, Integer> {


}
