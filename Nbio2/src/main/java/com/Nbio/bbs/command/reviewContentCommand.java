package com.Nbio.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Nbio.bbs.dao.dao;


public class reviewContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String ubid = request.getParameter("ubid");
		String reviewContent = request.getParameter("reviewContent");
		
		
		dao dao = new dao();
		dao.review(ubid, reviewContent);
	}

}
