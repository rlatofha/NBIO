package com.Nbio.bbs.command;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.dao.dao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class ProReWriteCommand implements purchaseInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
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
	    
	    
	    //String member = (String)session.getAttribute("member");
		String id = multipartRequest.getParameter("id");
		String pCode = multipartRequest.getParameter("pCode");
		
		String prTitle= multipartRequest.getParameter("prTitle");
		String prContent = multipartRequest.getParameter("prContent");
		String prfilepath = multipartRequest.getOriginalFileName("file");
		String prfilerealpath = multipartRequest.getOriginalFileName("file");
		
		System.out.println("---------");
		System.out.println(pCode);
		System.out.println("---------");


		
		dao dao = new dao();
		String a = dao.PrRewrite(id, pCode, prTitle, prContent, prfilepath, prfilerealpath);
		
		request.setAttribute("pCode", a);
		
	}

}
