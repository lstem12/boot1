package com.boot1.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.boot1.dao.UserDAO;
import com.boot1.dao.impl.UserDAOImpl;
import com.boot1.service.UserService;
import com.boot1.servlet.InitServlet;
import com.boot1.vo.UserInfoVO;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAOImpl();
	@Override
	public int insertUser(UserInfoVO user) {	
		if(userDAO.selecUserCheckId(user)!=null) {
			return -1;
		}
		return userDAO.insertUser(user);
	}

	@Override
	public int deleteUser(UserInfoVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(UserInfoVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfoVO selectUser(UserInfoVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserInfoVO selectUserForLogin(UserInfoVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfoVO> selectUserList(UserInfoVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doLogin(UserInfoVO user, HttpSession hs) {
		user = userDAO.selectUserForLogin(user);
		if(user!=null) {
			hs.setAttribute("user", user);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkId(UserInfoVO user) {
		user = userDAO.selecUserCheckId(user);
		if(user!=null) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		InitServlet is = new InitServlet();
		is.init();
		UserService userService = new UserServiceImpl();
		UserInfoVO userInfoVO = new UserInfoVO();
		userInfoVO.setUi_id("dkdk");
		
		boolean check = userService.checkId(userInfoVO);
		System.out.println(check);
	}
}
