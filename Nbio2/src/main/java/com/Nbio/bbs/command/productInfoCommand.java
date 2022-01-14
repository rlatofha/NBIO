package com.Nbio.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.prod;

public class productInfoCommand implements purchaseInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String id = (String)session.getAttribute("id");
		System.out.println("아이디 : "+id);
		String pCode = request.getParameter("pCode");
		
		
		
		
		System.out.println("---------");
		System.out.println(pCode);
		System.out.println("---------");
		
		dao dao = new dao();
		
		prod dto = dao.productInfo(pCode);
		request.setAttribute("productInfo", dto);
	}

}
