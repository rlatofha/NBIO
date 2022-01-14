package com.Nbio.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.PrDto;

public class COsteoListCommand implements CCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) { 
		dao dao = new dao(); 
		ArrayList<PrDto> dtos = dao.osteolist(); 
		request.setAttribute("osteolist", dtos);
	
		
	}
	
	
}
