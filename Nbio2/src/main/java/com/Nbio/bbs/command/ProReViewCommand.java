package com.Nbio.bbs.command;

import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.ProboardDto;


public class ProReViewCommand implements purchaseInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		String pCode = request.getParameter("pCode");
		System.out.println(pCode);
		dao dao = new dao();
		
		int count = dao.selectCnt("productboard"); //전체 행 개수
		String tempStart = request.getParameter("page"); //현재 페이지를 받아옴
		
		int startPage = 0; //limit의 시작값
		int onePageCnt = 5; //한 페이지의 행 개수
		
		count = (int)Math.ceil((double)count/(double)onePageCnt); //페이지 수 저장
		
		if(tempStart != null){
			startPage = (Integer.parseInt(tempStart)-1)*onePageCnt;
		}
		
		Vector<ProboardDto> dtos = dao.selectPage("productboard", startPage, onePageCnt,pCode);

		//ArrayList<ProboardDto> dtos = dao.prvlist(pCode);
		
		
		request.setAttribute("count", count);
		request.setAttribute("prvlist", dtos);

	}

}
