package com.Nbio.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.CBDto;




public class boardlistCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		dao dao = new dao();
		ArrayList<CBDto> dtos = dao.CBlist();
		
		request.setAttribute("CBlist", dtos);


	}

}
