package com.Nbio.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.JDto;



public class JInfoCommand implements Jcommand {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Object id1 = session.getAttribute("id");
		String id = (String)id1 ;
		dao dao = new dao();
		JDto dto = dao.info(id);
		
		request.setAttribute("info", dto);
		
		return null;
	}

}
