package com.boot1.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.boot1.dao.UserDAO;
import com.boot1.dao.impl.UserDAOImpl;
import com.boot1.listener.SessionListener;
import com.boot1.service.UserService;
import com.boot1.servlet.InitServlet;
import com.boot1.vo.UserInfoVO;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAOImpl();

	@Override
	public int insertUser(UserInfoVO user) {

		if (userDAO.selecUserCheckId(user) != null) {
			return -1;
		}
		return userDAO.insertUser(user);
	}

	@Override
	public int deleteUser(UserInfoVO user, HttpSession hs) {
		UserInfoVO sUser = (UserInfoVO)hs.getAttribute("user");
		if (sUser.getUi_password().equals(user.getUi_password())) {
			int cnt = userDAO.deleteUser(user);
			if (cnt == 1) {
				hs.invalidate();
				return cnt;
			}
		}

		return -1;
	}

	@Override
	public int updateUser(UserInfoVO user, HttpSession hs) {
		int cnt = userDAO.updateUser(user);
		if (cnt == 1) {
			hs.setAttribute("user", userDAO.selectUser(user));
		}
		return cnt;
	}

	@Override
	public UserInfoVO selectUser(UserInfoVO user) {
		return userDAO.selectUser(user);
	}

	@Override
	public List<UserInfoVO> selectUserList(UserInfoVO user) {
		return userDAO.selectUserList(user);
	}

	@Override
	public boolean doLogin(UserInfoVO user, HttpSession hs) {
		user = userDAO.selectUserForLogin(user);
		if (user != null) {
			SessionListener.checkUserId(user.getUi_id());
			hs.setAttribute("user", user);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkId(UserInfoVO user) {
		user = userDAO.selecUserCheckId(user);
		if (user != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkNickName(UserInfoVO user) {
		user = userDAO.selecUserCheckNickName(user);
		if (user != null) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		InitServlet is = new InitServlet();
		is.init();
		UserService userService = new UserServiceImpl();
		List<UserInfoVO> userList = new ArrayList<UserInfoVO>();
		
		userList = userService.selectUserList(null);
		System.out.println(userList);
	}

	@Override
	public int deleteUsers(int[] ui_nums) {
		for(int ui_num:ui_nums) {
			UserInfoVO userInfoVO = new UserInfoVO();
			userInfoVO.setUi_num(ui_num);
			userDAO.deleteUser(userInfoVO);
		}
		return ui_nums.length;
	}

}
