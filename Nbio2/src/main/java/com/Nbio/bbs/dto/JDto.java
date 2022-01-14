package com.Nbio.bbs.dto;

import java.sql.Timestamp;

public class JDto {
	String id;
	String pwd;
	String name;
	String mail;
	String tel;
	String address;
	String gender;
	String birth;
	String pwInfo;
	String pwAns;
	String date;
	

	public JDto(String id, String pwd, String name, String mail, String tel,  String address, String gender, String birth, 
			String pwInfo, String pwAns, String date) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.address = address;
		this.name = name;
		this.mail = mail;
		this.birth = birth;
		this.tel = tel;
		this.pwInfo = pwInfo;
		this.pwAns = pwAns;
		this.gender = gender;
		this.date = date;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	

}
