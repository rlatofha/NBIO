package com.Nbio.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;


public class JCheckCommand implements Jcommand {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");

		dao dao = new dao();
		int seq1 = dao.joinInfo(id);
		Object seq = Integer.toString(seq1);
	
		session.setAttribute("seq", seq);
		
		System.out.println(seq);
		
		return seq;
	}

}
