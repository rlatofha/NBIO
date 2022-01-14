package com.Nbio.bbs.dto;

public class exam {
	String pImg;
	String pName;
	String pCode;
	String pPrice;
	String cartQty;
	public exam(String pImg, String pName, String pCode,String pPrice, String cartQty) {
		super();
		this.pImg = pImg;
		this.pName = pName;
		this.pCode = pCode;
		this.pPrice = pPrice;
		this.cartQty = cartQty;
	}
	public String getpImg() {
		return pImg;
	}
	public void setpImg(String pImg) {
		this.pImg = pImg;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	public String getCartQty() {
		return cartQty;
	}
	public void setCartQty(String cartQty) {
		this.cartQty = cartQty;
	}
	
	
}
