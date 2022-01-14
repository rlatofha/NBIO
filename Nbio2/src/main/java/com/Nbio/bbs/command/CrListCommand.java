package com.Nbio.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.CDto;



public class CrListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		dao dao = new dao();
		ArrayList<CDto> dtos = dao.clist();
		request.setAttribute("list", dtos);

	}

}
