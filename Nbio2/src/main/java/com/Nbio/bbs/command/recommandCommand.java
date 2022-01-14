package com.Nbio.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.ReCDto;


public class recommandCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		// table recommand,  

		String hT = request.getParameter("hT");
		String nut = request.getParameter("nut");
		String dis = request.getParameter("dis");

		
		dao dao = new dao();
		ArrayList<ReCDto> dtos = dao.ReClist(hT, nut, dis);
		
		request.setAttribute("list", dtos);

	}

}
