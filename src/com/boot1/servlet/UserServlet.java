package com.boot1.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boot1.service.UserService;
import com.boot1.service.impl.UserServiceImpl;
import com.boot1.vo.UserInfoVO;
import com.google.gson.Gson;

@WebServlet("/ajax/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private UserService userService = new UserServiceImpl();
	private UserInfoVO userInfoVO = new UserInfoVO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		String cmd = request.getParameter("cmd");
		PrintWriter pw = response.getWriter();
		if("checkId".equals(cmd)) {
			String uiId = request.getParameter("ui_id");
			userInfoVO.setUi_id(uiId);
			Map<String,Object> result = new HashMap<>();
			result.put("result", userService.checkId(userInfoVO));
			pw.println(gson.toJson(result));		
		}
		if("checkNickName".equals(cmd)) {
			String uiNickName = request.getParameter("ui_nickname");
			userInfoVO.setUi_nickname(uiNickName);
			Map<String,Object> result = new HashMap<>();
			result.put("result", userService.checkNickName(userInfoVO));
			pw.println(gson.toJson(result));		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader br = request.getReader();
		String str;
		StringBuffer sb = new StringBuffer();
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		UserInfoVO user = gson.fromJson(sb.toString(), UserInfoVO.class);
		Map<String,Object> result = new HashMap<>();
		
		if("login".equals(user.getCmd())) {
			result.put("result", userService.doLogin(user, request.getSession()));
		}else if("signup".equals(user.getCmd())) {
			result.put("result", userService.insertUser(user));
		}else if("logout".equals(user.getCmd())) {
			request.getSession().invalidate();
			result.put("result", true);
		}
		String json = gson.toJson(result);
		PrintWriter pw = response.getWriter();
		pw.println(json);		
	}
}
