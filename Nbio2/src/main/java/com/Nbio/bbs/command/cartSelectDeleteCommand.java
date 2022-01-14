package com.Nbio.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;

public class cartSelectDeleteCommand implements purchaseInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		String id = (String)session.getAttribute("id");;
		System.out.println(id);
		String pCode = request.getParameter("pCode");
		
		dao dao = new dao();
		dao.cartSelectDelete(id, pCode);
		
	}

}
