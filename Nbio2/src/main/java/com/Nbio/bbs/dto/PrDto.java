package com.Nbio.bbs.dto;

import java.sql.Timestamp;

public class PrDto {

	String pCode; 
	String pName; 
	String brand; 
	String pQuan; 
	String pPrice; 
	String pImg; 
	Timestamp pDate; 
	String nut; 
	String hT; 
	String dis; 
	String pInfo;
	
	public PrDto() {
		// TODO Auto-generated constructor stub
	}
	
	public PrDto(String pCode, String pName, String brand, String pQuan, String pPrice, String pImg, Timestamp pDate,
			String nut, String hT, String dis, String pInfo) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.brand = brand;
		this.pQuan = pQuan;
		this.pPrice = pPrice;
		this.pImg = pImg;
		this.pDate = pDate;
		this.nut = nut;
		this.hT = hT;
		this.dis = dis;
		this.pInfo = pInfo;
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

	public Timestamp getpDate(Timestamp timestamp) {
		return pDate;
	}

	public void setpDate(Timestamp pDate) {
		this.pDate = pDate;
	}

	public String getNut() {
		return nut;
	}

	public void setNut(String nut) {
		this.nut = nut;
	}

	public String gethT() {
		return hT;
	}

	public void sethT(String hT) {
		this.hT = hT;
	}

	public String getDis() {
		return dis;
	}

	public void setDis(String dis) {
		this.dis = dis;
	}

	public String getpInfo() {
		return pInfo;
	}

	public void setpInfo(String pInfo) {
		this.pInfo = pInfo;
	} 
	
	
	
	
	
}
