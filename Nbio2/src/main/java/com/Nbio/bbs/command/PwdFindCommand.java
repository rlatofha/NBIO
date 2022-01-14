package com.Nbio.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;



public class PwdFindCommand implements Jcommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		String id= request.getParameter("id");
		String pwInfo= request.getParameter("pwInfo");
		String pwAns= request.getParameter("pwAns");
		
		dao dao = new dao();
		
		String pwd = dao.findpwd(id,pwInfo,pwAns);
		
		session.setAttribute("pwd", pwd);
		
		return pwd;
	}

}
