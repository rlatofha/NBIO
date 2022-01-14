package com.Nbio.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.cart;
import com.Nbio.bbs.dto.exam;
import com.Nbio.bbs.dto.prod;

public class cart_viewCommand implements purchaseInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		String id = (String)session.getAttribute("id");;
		System.out.println(id);
		
		dao dao = new dao();
		ArrayList<exam> dtos = dao.cart_view(id);
		request.setAttribute("cart_view", dtos);
		
	}

}
