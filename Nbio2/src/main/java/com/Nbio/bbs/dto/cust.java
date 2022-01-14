package com.Nbio.bbs.dto;

public class cust {
	String id;
	String pwd;
	String pwInfo;
	String pwAns;
	String name;
	String tel;
	String mail;
	String address;
	String birth;
	String gender;
	String uDate;
	String cmDate;
	String cdDate;
	public cust(String id, String pwd, String pwInfo, String pwAns, String name, String tel, String mail,
			String address, String birth, String gender, String uDate, String cmDate, String cdDate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.pwInfo = pwInfo;
		this.pwAns = pwAns;
		this.name = name;
		this.tel = tel;
		this.mail = mail;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
		this.uDate = uDate;
		this.cmDate = cmDate;
		this.cdDate = cdDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwInfo() {
		return pwInfo;
	}
	public void setPwInfo(String pwInfo) {
		this.pwInfo = pwInfo;
	}
	public String getPwAns() {
		return pwAns;
	}
	public void setPwAns(String pwAns) {
		this.pwAns = pwAns;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getuDate() {
		return uDate;
	}
	public void setuDate(String uDate) {
		this.uDate = uDate;
	}
	public String getCmDate() {
		return cmDate;
	}
	public void setCmDate(String cmDate) {
		this.cmDate = cmDate;
	}
	public String getCdDate() {
		return cdDate;
	}
	public void setCdDate(String cdDate) {
		this.cdDate = cdDate;
	}
	
	
}
