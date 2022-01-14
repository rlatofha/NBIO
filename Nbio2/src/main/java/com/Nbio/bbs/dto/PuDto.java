package com.Nbio.bbs.dto;

public class PuDto {
	String puid;
	String pucode;
	String purchaseprice;
	String purchasequantity;
	String purchasedate;
	
	
	
	public PuDto(String puid, String pucode, String purchaseprice, String purchasequantity, String purchasedate) {
		super();
		this.puid = puid;
		this.pucode = pucode;
		this.purchaseprice = purchaseprice;
		this.purchasequantity = purchasequantity;
		this.purchasedate = purchasedate;
	}


	
	
	/**
	 * @return the puid
	 */
	public String getPuid() {
		return puid;
	}


	/**
	 * @param puid the puid to set
	 */
	public void setPuid(String puid) {
		this.puid = puid;
	}


	/**
	 * @return the pucode
	 */
	public String getPucode() {
		return pucode;
	}


	/**
	 * @param pucode the pucode to set
	 */
	public void setPucode(String pucode) {
		this.pucode = pucode;
	}


	/**
	 * @return the perchaseprice
	 */
	public String getPurchaseprice() {
		return purchaseprice;
	}


	/**
	 * @param perchaseprice the perchaseprice to set
	 */
	public void setPurchaseprice(String purchaseprice) {
		this.purchaseprice = purchaseprice;
	}


	/**
	 * @return the perchasequantity
	 */
	public String getPurchasequantity() {
		return purchasequantity;
	}


	/**
	 * @param perchasequantity the perchasequantity to set
	 */
	public void setPurchasequantity(String purchasequantity) {
		this.purchasequantity = purchasequantity;
	}


	/**
	 * @return the purchasedate
	 */
	public String getPurchasedate() {
		return purchasedate;
	}


	/**
	 * @param purchasedate the purchasedate to set
	 */
	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}
	
	
	
	
	
	
	
	
}
