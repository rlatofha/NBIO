package com.Nbio.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.PrDto;
import com.Nbio.bbs.dto.PuDto;

public class CPurchaseCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		
		
		System.out.println("%%%%%%5");
		System.out.println(id);

		System.out.println("%%%%%%%");

		dao dao = new dao(); 
		ArrayList<PuDto> dtos = dao.CPlist(id); 
		request.setAttribute("CPlist", dtos);

	}

}
