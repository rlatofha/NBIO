package com.Nbio.bbs.dto;

public class CBDto {
	//field 
	String ubid;
	String inquiryType;
	String cTitle;
	//String cContent;
	//String cUploadfile;
	String cbdDate;
	
	//constructor
	public CBDto(String ubid, String inquiryType, String cTitle, String cbdDate) {
		super();
		this.ubid = ubid;
		this.inquiryType = inquiryType;
		this.cTitle = cTitle;
		//this.cContent = cContent;
		//this.cUploadfile = cUploadfile;
		this.cbdDate = cbdDate;
	}
	
	
	
	//method
	
	
	/**
	 * @return the ubid
	 */
	public String getUbid() {
		return ubid;
	}

	/**
	 * @param ubid the ubid to set
	 */
	public void setUbid(String ubid) {
		this.ubid = ubid;
	}

	/**
	 * @return the inquiryType
	 */
	public String getInquiryType() {
		return inquiryType;
	}

	/**
	 * @param inquiryType the inquiryType to set
	 */
	public void setInquiryType(String inquiryType) {
		this.inquiryType = inquiryType;
	}

	/**
	 * @return the cTitle
	 */
	public String getcTitle() {
		return cTitle;
	}

	/**
	 * @param cTitle the cTitle to set
	 */
	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}
	
	
	/**
	 * @return the cbiDate
	 */
	public String getCbdDate() {
		return cbdDate;
	}

	/**
	 * @param cbiDate the cbiDate to set
	 */
	public void setCbdDate(String cbdDate) {
		this.cbdDate = cbdDate;
	}
	

	
	
	
	
}
