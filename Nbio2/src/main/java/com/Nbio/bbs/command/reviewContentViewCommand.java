package com.Nbio.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.ReDto;



public class reviewContentViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String ubid = request.getParameter("ubid");
		
		dao dao = new dao();
		//ReDto dto = dao.reviewboardview(ubid);
		
		ArrayList<ReDto> dtos = dao.reviewboardview(ubid);
		
		request.setAttribute("reboard_view", dtos);
		
		//String ubid = request.getParameter("ubid");
		//String cTitle = request.getParameter("cTitle");
		
		System.out.println("///////////////");
		System.out.println(ubid);
		System.out.println("///////////////");
		//Dao dao = new Dao();
		
		//ReDto dto = dao.reviewboardview(ubid);
		
		//SumReDto dto = dao.reviewboardview(cTitle);
		
		//request.setAttribute("reboard_view", dto);
	}

}
