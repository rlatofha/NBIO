package com.Nbio.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;

public class PrReviewBoardDeleteCommand implements purchaseInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		
		String prid =(String)session.getAttribute("id");
		
		String pCode= request.getParameter("pCode");
		dao dao = new dao();
		
		String code =dao.PrReBodelete(prid, pCode);
		
		request.setAttribute("pCode", code);
		
		

	}

}
