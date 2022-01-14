package com.Nbio.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.PrDto;
import com.Nbio.bbs.dto.SPrDto;



public class PrListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		dao dao = new dao();
		ArrayList<SPrDto> dtos = dao.plist();
		request.setAttribute("plist", dtos);

	}

}
