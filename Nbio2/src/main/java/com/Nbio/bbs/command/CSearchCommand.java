package com.Nbio.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.PDto;
import com.Nbio.bbs.dto.PrDto;

public class CSearchCommand implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) { 
		
		String searchName = request.getParameter("search");
		String searchContent = request.getParameter("content");
		
		dao dao = new dao();
		int count = dao.selectSortationCnt("product",searchName, searchContent); //전체 행 개수
		String tempStart = request.getParameter("page"); //현재 페이지를 받아옴
		
		int startPage = 0; //limit의 시작값
		int onePageCnt = 8; //한 페이지의 행 개수
		
		count = (int)Math.ceil((double)count/(double)onePageCnt); //페이지 수 저장
		
		if(tempStart != null){
			startPage = (Integer.parseInt(tempStart)-1)*onePageCnt;
		}
		
		ArrayList<PDto> v = dao.list(startPage, onePageCnt, "product", searchName, searchContent);
		request.setAttribute("list", v);
		request.setAttribute("count", count);
	}
}