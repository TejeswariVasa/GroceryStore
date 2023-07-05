package com.cg.grocery.dto;

public class OrderDetails {
	private String itemId;
	private String itemName;
	private int price;
	private int quantity;
	public OrderDetails() {
	}
	public OrderDetails(String itemId, String itemName, int price, int quantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetails [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
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
