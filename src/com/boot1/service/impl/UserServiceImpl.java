package com.boot1.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.boot1.dao.UserDAO;
import com.boot1.dao.impl.UserDAOImpl;
import com.boot1.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAOImpl();

	@Override
	public Map<String, Object> userServiceLogin(Map<String, String> user) {
		Map<String, Object> rMap = new HashMap<>();
		Map<String, Object> tmpUser = userDAO.userDAOLogin(user);
		rMap.put("result", "fail");
		rMap.put("msg", "아이디랑 비밀번호를 확인해주세요.");
		rMap.put("url", "/views/user/login");
		if (tmpUser != null) {
				rMap.put("result", "success");
				rMap.put("msg", "로그인완료");
				rMap.put("ui_id", tmpUser.get("ui_id"));
				rMap.put("url", "/");
		}
		return rMap;
	}

}
