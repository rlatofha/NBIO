package com.Nbio.bbs.dto;

public class ReCDto {
	
	String pName ; 
	String brand ; // count(*) as count면 as 뒤에 있는 변수 호출
	String pPrice;
	String hT ;
	String nut ;
	String dis ;
	String pImg ;
	
	public ReCDto(String pName, String brand, String pPrice, String hT, String nut, String dis, String pImg) {
		super();
		this.pName = pName;
		this.brand = brand;
		this.pPrice = pPrice;
		this.hT = hT;
		this.nut = nut;
		this.dis = dis;
		this.pImg = pImg;
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
	
	
	

	
	
	
	
	
	
	


}
