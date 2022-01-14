package com.Nbio.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Nbio.bbs.dao.dao;



public class JJoinCommand implements Jcommand {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String pwInfo = request.getParameter("pwInfo");
		String pwAns = request.getParameter("pwAns");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String mail = request.getParameter("mail");
		String sample4_jibunAddress = request.getParameter("sample4_jibunAddress");
		String sample4_detailAddress = request.getParameter("sample4_detailAddress");
		String sample4_extraAddress = request.getParameter("sample4_extraAddress");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String address = sample4_jibunAddress+sample4_detailAddress+sample4_extraAddress;

		dao dao = new dao();
		System.out.println("======jjoin======");
		
		dao.join(id,pwd,pwInfo,pwAns,name,tel,mail,address,birth,gender);
		
		return dao;
		
	}

}
