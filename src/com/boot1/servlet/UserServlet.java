package com.boot1.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boot1.service.UserService;
import com.boot1.service.impl.UserServiceImpl;
import com.google.gson.Gson;

@WebServlet("/ajax/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader br = request.getReader();
		String str;
		StringBuffer sb = new StringBuffer();
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		Map<String, String> param = gson.fromJson(sb.toString(), Map.class);
		if ("login".equals(param.get("cmd"))) {
			Map<String, Object> rMap = userService.userServiceLogin(param);
			if ("success".equals(rMap.get("result"))) {
				HttpSession session = request.getSession();
				session.setAttribute("id", rMap.get("ui_id"));
				String json = gson.toJson(rMap);
				PrintWriter pw = response.getWriter();
				pw.println(json);
			}else if ("fail".equals(rMap.get("result"))) {
				String json = gson.toJson(rMap);
				PrintWriter pw = response.getWriter();
				pw.println(json);
			}
		}
	}
}
