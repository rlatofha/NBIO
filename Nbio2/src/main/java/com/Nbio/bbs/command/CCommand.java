package com.Nbio.bbs.command;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface CCommand {

	
	public void execute(HttpServletRequest request, HttpServletResponse response ,HttpSession session);

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}
