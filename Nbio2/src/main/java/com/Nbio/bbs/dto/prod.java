package com.Nbio.bbs.dto;

public class prod {

	//상품 기본 정
	String pCode;
	String pName;
	String brand;
	String pQuan;
	String pPrice;
	String pImg;
	String pDate;
	//상품정보
	String pInfo;
	String dis;
	String hT;
	String nut;
	public prod(String pCode, String pName, String brand, String pQuan, String pPrice, String pImg, String pDate,
			String pInfo, String dis, String hT, String nut) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.brand = brand;
		this.pQuan = pQuan;
		this.pPrice = pPrice;
		this.pImg = pImg;
		this.pDate = pDate;
		
		this.pInfo = pInfo;
		this.dis = dis;
		this.hT = hT;
		this.nut = nut;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getpQuan() {
		return pQuan;
	}
	public void setpQuan(String pQuan) {
		this.pQuan = pQuan;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	public String getpImg() {
		return pImg;
	}
	public void setpImg(String pImg) {
		this.pImg = pImg;
	}
	public String getpDate() {
		return pDate;
	}
	public void setpDate(String pDate) {
		this.pDate = pDate;
	}
	public String getpInfo() {
		return pInfo;
	}
	public void setpInfo(String pInfo) {
		this.pInfo = pInfo;
	}
	public String getDis() {
		return dis;
	}
	public void setDis(String dis) {
		this.dis = dis;
	}
	public String gethT() {
		return hT;
	}
	public void sethT(String hT) {
		this.hT = hT;
	}
	public String getNut() {
		return nut;
	}
	public void setNut(String nut) {
		this.nut = nut;
	}
	
	
	
	
	
	
}
