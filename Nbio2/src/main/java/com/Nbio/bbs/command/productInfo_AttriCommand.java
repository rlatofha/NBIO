package com.Nbio.bbs.command;

import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.ProboardDto;
import com.Nbio.bbs.dto.prod;

public class productInfo_AttriCommand implements purchaseInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		
		String id = (String)session.getAttribute("id");
		System.out.println("아이디 : "+id);
		String pCode = (String)request.getAttribute("pCode");
		
		
		
		String table = (String)request.getAttribute("table");
		int start = (int)request.getAttribute("start");
		int pageCnt = (int)request.getAttribute("pageCnt");
		
		
		
		
		
		
		System.out.println("---------");
		System.out.println(pCode);
		System.out.println("---------");
		
		dao dao = new dao();
		
		//상품정보
		prod dto = dao.productInfo(pCode);
		request.setAttribute("productInfo", dto);
		//////////////////////////////////////////
		//게시글 리스트
		//ArrayList<ProboardDto> dtos = dao.prvlist(pCode);
		
		//Vector<ProboardDto> dtos = dao.selectPage(pCode, table, start, pageCnt);
		
		Vector<ProboardDto> dtos = dao.selectPage(table, start, pageCnt,pCode);
		
		request.setAttribute("prvlist", dtos);
	}

}
