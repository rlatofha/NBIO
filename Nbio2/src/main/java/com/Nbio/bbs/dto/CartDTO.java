package com.Nbio.bbs.dto;

public class CartDTO {
	private int cart_no;
	private String id;
	private int unitPrice;
	private int pdQuantity;
	private String productName;
	private String color;
	private String size;
	private int amount;
	private int pdCode;
	private String productImg1;
	private String [] deleteCart;	
	
	
	
	
	public CartDTO(int cart_no, String id, int unitPrice, int pdQuantity, String productName, String color, String size,
			int amount, int pdCode, String productImg1, String[] deleteCart) {
		super();
		this.cart_no = cart_no;
		this.id = id;
		this.unitPrice = unitPrice;
		this.pdQuantity = pdQuantity;
		this.productName = productName;
		this.color = color;
		this.size = size;
		this.amount = amount;
		this.pdCode = pdCode;
		this.productImg1 = productImg1;
		this.deleteCart = deleteCart;
	}
	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getPdQuantity() {
		return pdQuantity;
	}
	public void setPdQuantity(int pdQuantity) {
		this.pdQuantity = pdQuantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPdCode() {
		return pdCode;
	}
	public void setPdCode(int pdCode) {
		this.pdCode = pdCode;
	}
	public String getProductImg1() {
		return productImg1;
	}
	public void setProductImg1(String productImg1) {
		this.productImg1 = productImg1;
	}
	public String[] getDeleteCart() {
		
		return deleteCart;
	}
	public void setDeleteCart(String[] deleteCart) {
		this.deleteCart = deleteCart;
	}
}

