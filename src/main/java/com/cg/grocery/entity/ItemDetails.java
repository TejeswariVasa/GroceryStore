package com.cg.grocery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Details")
public class ItemDetails {
	@Id
	@GeneratedValue
	private int itemid;
	private String itemName;
	private int price;
	private int quantity;
	
	@Override
	public String toString() {
		return "ItemDetails [itemid=" + itemid + ", itemName=" + itemName + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	public ItemDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemDetails(int itemid, String itemName, int price, int quantity) {
		super();
		this.itemid = itemid;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
