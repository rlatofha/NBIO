package com.Nbio.bbs.command;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;
import com.Nbio.bbs.dto.CBDto1;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class boardcontentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//파일업로드 부분 
		/*
	    ServletContext context = request.getServletContext();
	    String directory = context.getRealPath("/upload/");
	    
	    int maxSize = 1024 * 1024 * 100;
	    String encoding = "utf-8"; 
	   
	    MultipartRequest multipartRequest = null;
	    
	    try {
	    	multipartRequest = new MultipartRequest(request, directory, maxSize, encoding, new DefaultFileRenamePolicy());
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
	    */
		

		
	    
		String ubid = request.getParameter("ubid");
		
		System.out.println("***----------");
		System.out.println(ubid);
		System.out.println("***----------");
		dao dao = new dao();
		CBDto1 dto = dao.boardview(ubid);
		
		request.setAttribute("board_view", dto);
		//request.setAttribute("modify", dto);
		

	}

}
