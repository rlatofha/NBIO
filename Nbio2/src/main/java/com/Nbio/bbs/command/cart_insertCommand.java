package com.Nbio.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;

public class cart_insertCommand implements purchaseInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		String id = (String)session.getAttribute("id");
		System.out.println(id);
		String cPcode = request.getParameter("pCode");
		String cartQty = "1";
		//String cartQty = request.getParameter("cartQty");
		
		dao dao = new dao();
		dao.cart_insert(id, cPcode,cartQty);
		

	}

}
