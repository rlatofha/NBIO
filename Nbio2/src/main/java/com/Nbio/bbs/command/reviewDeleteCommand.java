package com.Nbio.bbs.command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Nbio.bbs.dao.dao;


public class reviewDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String reviewContent =request.getParameter("reviewContent");
		dao dao = new dao();
		dao.reviewdelete(reviewContent);

	}

}
