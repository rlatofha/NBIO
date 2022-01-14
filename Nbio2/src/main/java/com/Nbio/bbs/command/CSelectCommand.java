package com.Nbio.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.CDto;



public class CSelectCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String query = request.getParameter("query");
		String content = request.getParameter("content");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		
	
		dao dao = new dao();
		ArrayList<CDto> dtos = dao.slist(query, content, startdate, enddate);
		request.setAttribute("list", dtos);

	}

}
