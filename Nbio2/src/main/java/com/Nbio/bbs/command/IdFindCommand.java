package com.Nbio.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;

public class IdFindCommand implements Jcommand {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) {
	
	HttpSession session = request.getSession();
		
	String name= request.getParameter("name");
	String mail= request.getParameter("mail");
	
	dao dao = new dao();
	String id = dao.findid(name, mail);
	
	session.setAttribute("id", id);
		
	return id;
	}

}
