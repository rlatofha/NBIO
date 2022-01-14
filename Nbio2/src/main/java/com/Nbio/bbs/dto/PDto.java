package com.Nbio.bbs.dto;

public class PDto {

	String puid;
	String pucode;
	String purchaseprice;
	String purchasequantitiy;
	String purchasedate;
	String pumDate;
	String pName;
	
	public PDto() {
		// TODO Auto-generated constructor stub
	}
	
	public PDto(String puid, String pucode, String purchaseprice, String purchasequantitiy, String purchasedate,
			String pumDate, String pName) {
		super();
		this.puid = puid;
		this.pucode = pucode;
		this.purchaseprice = purchaseprice;
		this.purchasequantitiy = purchasequantitiy;
		this.purchasedate = purchasedate;
		this.pumDate = pumDate;
		this.pName = pName;
	}
	public String getPuid() {
		return puid;
	}
	public void setPuid(String puid) {
		this.puid = puid;
	}
	public String getPucode() {
		return pucode;
	}
	public void setPucode(String pucode) {
		this.pucode = pucode;
	}
	public String getPurchaseprice() {
		return purchaseprice;
	}
	public void setPurchaseprice(String purchaseprice) {
		this.purchaseprice = purchaseprice;
	}
	public String getPurchasequantitiy() {
		return purchasequantitiy;
	}
	public void setPurchasequantitiy(String purchasequantitiy) {
		this.purchasequantitiy = purchasequantitiy;
	}
	public String getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}
	public String getPumDate() {
		return pumDate;
	}
	public void setPumDate(String pumDate) {
		this.pumDate = pumDate;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	
	
}
