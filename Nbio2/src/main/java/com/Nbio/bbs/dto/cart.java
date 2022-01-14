package com.Nbio.bbs.dto;

public class cart {
		
	String cartindex;
	String cartid;
	String cartpcode;
	String caiDate;
	String camDate;
	String cadDate;
	String cartQty;
	public cart(String cartindex, String cartid, String cartpcode, String caiDate, String camDate, String cadDate,
			String cartQty) {
		super();
		this.cartindex = cartindex;
		this.cartid = cartid;
		this.cartpcode = cartpcode;
		this.caiDate = caiDate;
		this.camDate = camDate;
		this.cadDate = cadDate;
		this.cartQty = cartQty;
	}
	public String getCartindex() {
		return cartindex;
	}
	public void setCartindex(String cartindex) {
		this.cartindex = cartindex;
	}
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public String getCartpcode() {
		return cartpcode;
	}
	public void setCartpcode(String cartpcode) {
		this.cartpcode = cartpcode;
	}
	public String getCaiDate() {
		return caiDate;
	}
	public void setCaiDate(String caiDate) {
		this.caiDate = caiDate;
	}
	public String getCamDate() {
		return camDate;
	}
	public void setCamDate(String camDate) {
		this.camDate = camDate;
	}
	public String getCadDate() {
		return cadDate;
	}
	public void setCadDate(String cadDate) {
		this.cadDate = cadDate;
	}
	public String getCartQty() {
		return cartQty;
	}
	public void setCartQty(String cartQty) {
		this.cartQty = cartQty;
	}
	
	
	
	
	
	
}
