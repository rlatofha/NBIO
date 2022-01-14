package com.Nbio.bbs.command;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.PDto;




public class PSearchCommand implements Jcommand {

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) {

		String search = request.getParameter("search");
		String content = request.getParameter("content");
		dao dao = new dao();
		
		ArrayList<PDto> dtos = dao.list(search, content);
		request.setAttribute("list", dtos);
		
		return null;
	}

}
