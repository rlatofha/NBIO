package com.Nbio.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Jcommand {
	public Object execute(HttpServletRequest request, HttpServletResponse response);
	
}
