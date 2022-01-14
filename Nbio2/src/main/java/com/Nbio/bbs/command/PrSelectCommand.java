package com.Nbio.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.PrDto;
import com.Nbio.bbs.dto.SPrDto;



public class PrSelectCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String query = request.getParameter("query");
		String content = request.getParameter("content");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		
	
		dao dao = new dao();
		ArrayList<SPrDto> dtos = dao.prlist(query, content, startdate, enddate);
		request.setAttribute("plist", dtos);

	}

}
