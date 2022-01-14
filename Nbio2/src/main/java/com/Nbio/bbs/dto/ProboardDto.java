package com.Nbio.bbs.dto;

public class ProboardDto {
	
	int num; 
	String prid; 
	String prContent; 
	String prTitle;
	String prfilepath; 
	String prfilerealpath;
	String prDate;
	
	
	public ProboardDto(int num, String prid, String prContent, String prTitle, String prfilepath,
			String prfilerealpath, String prDate) {
		super();
		this.num = num;
		this.prid = prid;
		this.prContent = prContent;
		this.prTitle = prTitle;
		this.prfilepath = prfilepath;
		this.prfilerealpath = prfilerealpath;
		this.prDate = prDate;
	}


	/**
	 * @return the index
	 */
	public int getNum() {
		return num;
	}


	/**
	 * @param index the index to set
	 */
	public void setNum(int num) {
		this.num = num;
	}


	/**
	 * @return the prid
	 */
	public String getPrid() {
		return prid;
	}


	/**
	 * @param prid the prid to set
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}


	/**
	 * @return the prContent
	 */
	public String getPrContent() {
		return prContent;
	}


	/**
	 * @param prContent the prContent to set
	 */
	public void setPrContent(String prContent) {
		this.prContent = prContent;
	}


	/**
	 * @return the prTitle
	 */
	public String getPrTitle() {
		return prTitle;
	}


	/**
	 * @param prTitle the prTitle to set
	 */
	public void setPrTitle(String prTitle) {
		this.prTitle = prTitle;
	}


	/**
	 * @return the prfilepath
	 */
	public String getPrfilepath() {
		return prfilepath;
	}


	/**
	 * @param prfilepath the prfilepath to set
	 */
	public void setPrfilepath(String prfilepath) {
		this.prfilepath = prfilepath;
	}


	/**
	 * @return the prfilerealpath
	 */
	public String getPrfilerealpath() {
		return prfilerealpath;
	}


	/**
	 * @param prfilerealpath the prfilerealpath to set
	 */
	public void setPrfilerealpath(String prfilerealpath) {
		this.prfilerealpath = prfilerealpath;
	}


	/**
	 * @return the prDate
	 */
	public String getPrDate() {
		return prDate;
	}


	/**
	 * @param prDate the prDate to set
	 */
	public void setPrDate(String prDate) {
		this.prDate = prDate;
	} 
	
	
	
	

}
