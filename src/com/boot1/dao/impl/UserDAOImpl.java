package com.boot1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.boot1.dao.UserDAO;
import com.boot1.servlet.InitServlet;
import com.boot1.vo.UserInfoVO;

public class UserDAOImpl implements UserDAO {

	@Override
	public int insertUser(UserInfoVO user) {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public List<UserInfoVO> selectUserList(UserInfoVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoVO selectUserForLogin(UserInfoVO user) {
		String sql = "select * from user_info where ui_id=? and ui_password=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUi_id());
			ps.setString(2, user.getUi_password());
			rs = ps.executeQuery();
			if(rs.next()) {
				UserInfoVO ui = new UserInfoVO();
				ui.setUi_num(rs.getInt("ui_num"));
				ui.setUi_age(rs.getInt("ui_age"));
				ui.setUi_name(rs.getString("ui_name"));
				ui.setUi_birth(rs.getString("ui_birth"));
				ui.setUi_id(rs.getString("ui_id"));
				ui.setUi_phone(rs.getString("ui_phone"));
				ui.setUi_email(rs.getString("ui_email"));
				ui.setUi_credat(rs.getString("ui_credat"));
				ui.setUi_nickname(rs.getString("ui_nickname"));
				return ui;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			InitServlet.close(rs, ps, con);
		}
		return null;
	}

}
