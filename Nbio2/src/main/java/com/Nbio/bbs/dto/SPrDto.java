package com.Nbio.bbs.dto;

import java.sql.Timestamp;

public class SPrDto {
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
	
	
	public SPrDto(String pCode, String pName, String brand, String pQuan, String pPrice, String pImg, Timestamp pDate,
			String nut, String hT, String dis) {
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
	}


	/**
	 * @return the pCode
	 */
	public String getpCode() {
		return pCode;
	}


	/**
	 * @param pCode the pCode to set
	 */
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}


	/**
	 * @return the pName
	 */
	public String getpName() {
		return pName;
	}


	/**
	 * @param pName the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}


	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}


	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}


	/**
	 * @return the pQuan
	 */
	public String getpQuan() {
		return pQuan;
	}


	/**
	 * @param pQuan the pQuan to set
	 */
	public void setpQuan(String pQuan) {
		this.pQuan = pQuan;
	}


	/**
	 * @return the pPrice
	 */
	public String getpPrice() {
		return pPrice;
	}


	/**
	 * @param pPrice the pPrice to set
	 */
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}


	/**
	 * @return the pImg
	 */
	public String getpImg() {
		return pImg;
	}


	/**
	 * @param pImg the pImg to set
	 */
	public void setpImg(String pImg) {
		this.pImg = pImg;
	}


	/**
	 * @return the pDate
	 */
	public Timestamp getpDate() {
		return pDate;
	}


	/**
	 * @param pDate the pDate to set
	 */
	public void setpDate(Timestamp pDate) {
		this.pDate = pDate;
	}


	/**
	 * @return the nut
	 */
	public String getNut() {
		return nut;
	}


	/**
	 * @param nut the nut to set
	 */
	public void setNut(String nut) {
		this.nut = nut;
	}


	/**
	 * @return the hT
	 */
	public String gethT() {
		return hT;
	}


	/**
	 * @param hT the hT to set
	 */
	public void sethT(String hT) {
		this.hT = hT;
	}


	/**
	 * @return the dis
	 */
	public String getDis() {
		return dis;
	}


	/**
	 * @param dis the dis to set
	 */
	public void setDis(String dis) {
		this.dis = dis;
	} 
	
	
	
	
	

}
