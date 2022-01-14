package com.Nbio.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;

public class purchase_info_Command implements purchaseInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		// 단일 구매 구현
		String id = (String)session.getAttribute("id");;
		System.out.println(id);
		String pPrice = request.getParameter("pPrice");
		String pCode = request.getParameter("pCode");
		String purQuan = request.getParameter("purQuan");//구매수량
		String pQuan = request.getParameter("pQuan");//잔여수량
		
		System.out.println("아이디"+id);
		System.out.println("상품가격"+pPrice);
		System.out.println("상품코드"+pCode);
		System.out.println("구매갯수"+purQuan);
		System.out.println("상품잔여갯수"+pQuan);
		
		dao dao = new dao();
		dao.purchaseACT(id, pCode, purQuan, pPrice, pQuan);
		
	}

}
