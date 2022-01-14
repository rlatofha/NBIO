package com.Nbio.bbs.dto;

public class pur {
	
	String puid;
	String pucode;
	String perchaseprice;
	String perchasequantity;
	String purchasedate;

	String pumDate;
	String pudDate;
	String rdDate;
	String rmDate;
	String riDate;
	public pur(String puid, String pucode, String perchaseprice, String perchasequantity, String purchasedate,
			 String pumDate, String pudDate, String rdDate, String rmDate, String riDate) {
		super();
		this.puid = puid;
		this.pucode = pucode;
		this.perchaseprice = perchaseprice;
		this.perchasequantity = perchasequantity;
		this.purchasedate = purchasedate;

		this.pumDate = pumDate;
		this.pudDate = pudDate;
		this.rdDate = rdDate;
		this.rmDate = rmDate;
		this.riDate = riDate;
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
	public String getPerchaseprice() {
		return perchaseprice;
	}
	public void setPerchaseprice(String perchaseprice) {
		this.perchaseprice = perchaseprice;
	}
	public String getPerchasequantity() {
		return perchasequantity;
	}
	public void setPerchasequantity(String perchasequantity) {
		this.perchasequantity = perchasequantity;
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
	public String getPudDate() {
		return pudDate;
	}
	public void setPudDate(String pudDate) {
		this.pudDate = pudDate;
	}
	public String getRdDate() {
		return rdDate;
	}
	public void setRdDate(String rdDate) {
		this.rdDate = rdDate;
	}
	public String getRmDate() {
		return rmDate;
	}
	public void setRmDate(String rmDate) {
		this.rmDate = rmDate;
	}
	public String getRiDate() {
		return riDate;
	}
	public void setRiDate(String riDate) {
		this.riDate = riDate;
	}
	

	
	
}
