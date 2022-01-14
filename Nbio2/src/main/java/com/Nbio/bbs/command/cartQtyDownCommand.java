package com.Nbio.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;

public class cartQtyDownCommand implements purchaseInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		//카트 시퀸스 다운 커맨드
		
		String id = (String)session.getAttribute("id");
		System.out.println("아이디 : "+id);
		String pCode = request.getParameter("pCode");
		dao dao = new dao();
	 	
	 	dao.cartQtyDown(id, pCode);;
	}

}
