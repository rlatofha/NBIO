package com.Nbio.bbs.dto;

public class ReDto {
	String ruid;
	String reviewDate;
	String reviewContent;
	
	
	public ReDto(String ruid, String reviewDate, String reviewContent) {
		super();
		this.ruid = ruid;
		this.reviewDate = reviewDate;
		this.reviewContent = reviewContent;
	}


	public String getRuid() {
		return ruid;
	}


	public void setRuid(String ruid) {
		this.ruid = ruid;
	}


	public String getReviewDate() {
		return reviewDate;
	}


	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}


	public String getReviewContent() {
		return reviewContent;
	}


	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	} 
	
	
	
	
}
