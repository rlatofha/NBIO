package com.Nbio.bbs.command;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class boardwriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session =request.getSession();
		String id = (String)session.getAttribute("id");
		
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
		
		String ubid = multipartRequest.getParameter("ubid");
		String inquiryType = multipartRequest.getParameter("inquiryType");
		String cTitle = multipartRequest.getParameter("cTitle");
		String cContent = multipartRequest.getParameter("cContent");
		String cUploadfile = multipartRequest.getOriginalFileName("file");
		String cUploadfilepath = multipartRequest.getOriginalFileName("file");
		
		System.out.println("--------------");
		System.out.println(ubid);
		System.out.println(id);
		System.out.println("--------------");
		

		
		dao dao = new dao();
		dao.write(ubid, inquiryType, cTitle, cContent, cUploadfile, cUploadfilepath );

	}

}
