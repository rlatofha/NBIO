package com.Nbio.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;



public class JLoginCommand implements Jcommand {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		dao dao=new dao();
		int chk1 = dao.login(id,pwd);
		Object chk = Integer.toString(chk1);
		System.out.println(chk);
  		session.setAttribute("id", id);
		session.setAttribute("chk", chk);
		return chk;
		
		
	}

}
