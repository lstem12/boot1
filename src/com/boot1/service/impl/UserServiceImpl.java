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
		rMap.put("result", "fail");
		rMap.put("msg", "아이디와 비밀번호를 확인해주세요.");
		Map<String, Object> tmpUser = userDAO.userDAOLogin(user);
		if (tmpUser != null) {
				rMap.put("result", "sucess");
				rMap.put("msg", "로그인완료");
		}
		return rMap;
	}

}
