package com.cg.grocery.dto;

public class CreateOrderRequest {
	private int itemId;
	private String itemName;
	private int price;
	private int quantity;
	public CreateOrderRequest() {
			}
	public CreateOrderRequest(int itemId, String itemName, int price, int quantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CreateOrderRequest [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
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
