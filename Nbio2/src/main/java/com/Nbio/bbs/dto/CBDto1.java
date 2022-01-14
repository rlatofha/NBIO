package com.Nbio.bbs.dto;

public class CBDto1 {
	//field 
	String ubid;
	String inquiryType;
	String cTitle;
	String cContent;
	String cUploadfile;
	String cUploadfilepath;
	
	public CBDto1(String ubid, String inquiryType, String cTitle, String cContent, String cUploadfile,
			String cUploadfilepath) {
		super();
		this.ubid = ubid;
		this.inquiryType = inquiryType;
		this.cTitle = cTitle;
		this.cContent = cContent;
		this.cUploadfile = cUploadfile;
		this.cUploadfilepath = cUploadfilepath;
		
	}

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
	 * @return the cContent
	 */
	public String getcContent() {
		return cContent;
	}

	/**
	 * @param cContent the cContent to set
	 */
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	/**
	 * @return the cUploadfile
	 */
	public String getcUploadfile() {
		return cUploadfile;
	}

	/**
	 * @param cUploadfile the cUploadfile to set
	 */
	public void setcUploadfile(String cUploadfile) {
		this.cUploadfile = cUploadfile;
	}

	/**
	 * @return the cUploadfilepath
	 */
	public String getcUploadfilepath() {
		return cUploadfilepath;
	}

	/**
	 * @param cUploadfilepath the cUploadfilepath to set
	 */
	public void setcUploadfilepath(String cUploadfilepath) {
		this.cUploadfilepath = cUploadfilepath;
	}
	


	

}
