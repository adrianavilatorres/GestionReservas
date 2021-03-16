package com.iesvdc.acceso.simplecrud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LogOut
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie loginCookie = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("ges_res.user")) {
					loginCookie = cookie;
					break;
				}
			}
		}
		if (loginCookie != null) {
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
		}
		response.sendRedirect("login.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}