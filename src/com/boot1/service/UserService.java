package com.boot1.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.boot1.vo.UserInfoVO;

public interface UserService {

	int insertUser(UserInfoVO user);
	int deleteUser(UserInfoVO user, HttpSession hs);
	int deleteUsers(int[] ui_nums);
	int updateUser(UserInfoVO user, HttpSession hs);
	UserInfoVO selectUser(UserInfoVO user);
	boolean doLogin(UserInfoVO user, HttpSession hs);
	List<UserInfoVO> selectUserList(UserInfoVO user);
	boolean checkId(UserInfoVO user);
	boolean checkNickName(UserInfoVO user);
}
