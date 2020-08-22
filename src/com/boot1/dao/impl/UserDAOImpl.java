package com.boot1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.boot1.dao.UserDAO;
import com.boot1.service.UserService;
import com.boot1.service.impl.UserServiceImpl;
import com.boot1.servlet.InitServlet;
import com.boot1.vo.UserInfoVO;

public class UserDAOImpl implements UserDAO {

	@Override
	public int insertUser(UserInfoVO user) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into user_info(ui_num, ui_name, ui_age, ui_birth, ui_id, ui_password, ui_phone, ui_email, ui_credat, ui_nickname) \r\n" + 
				"values(seq_ui_num.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate, ?)";
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUi_name());
			ps.setInt(2, user.getUi_age());
			ps.setString(3, user.getUi_birth());
			ps.setString(4, user.getUi_id());
			ps.setString(5, user.getUi_password());
			ps.setString(6, user.getUi_phone());
			ps.setString(7, user.getUi_email());
			ps.setString(8, user.getUi_nickname());
			result = ps.executeUpdate();
			con.commit();
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
				InitServlet.close(ps, con);
		}

		return 0;
	}

	@Override
	public int deleteUser(UserInfoVO user) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = InitServlet.getConnection();
			String sql = "delete from user_info where ui_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getUi_num());
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			InitServlet.close(ps, con);
		}
		return 0;
	}

	@Override
	public int updateUser(UserInfoVO user) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = InitServlet.getConnection();
			String sql = "update user_info\r\n" + 
					"set \r\n" + 
					"ui_name=?,\r\n" + 
					"ui_age = ?,\r\n" + 
					"ui_birth = ?,\r\n" + 
					"UI_PASSWORD = ?,\r\n" + 
					"ui_phone = ?,\r\n" + 
					"ui_email = ?,\r\n" + 
					"ui_nickname = ?\r\n" + 
					"where ui_num = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUi_name());
			ps.setInt(2, user.getUi_age());
			ps.setString(3, user.getUi_birth());
			ps.setString(4, user.getUi_password());
			ps.setString(5, user.getUi_phone());
			ps.setString(6, user.getUi_email());
			ps.setString(7, user.getUi_nickname());
			ps.setInt(8, user.getUi_num());
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			InitServlet.close(ps, con);
		}
		
		return 0;
	}

	@Override
	public UserInfoVO selectUser(UserInfoVO user) {

		String sql = "select ui_num, ui_name, ui_age, ui_birth, ui_id, "
				+ "ui_password, ui_phone, ui_email, ui_credat, ui_nickname, ui_admin "
				+ "from user_info where ui_num=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getUi_num());
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
				ui.setUi_admin(rs.getString("ui_admin"));
				return ui;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			InitServlet.close(rs, ps, con);
		}
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
				ui.setUi_password(rs.getString("ui_password"));
				ui.setUi_phone(rs.getString("ui_phone"));
				ui.setUi_email(rs.getString("ui_email"));
				ui.setUi_credat(rs.getString("ui_credat"));
				ui.setUi_nickname(rs.getString("ui_nickname"));
				ui.setUi_admin(rs.getString("ui_admin"));
				return ui;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			InitServlet.close(rs, ps, con);
		}
		return null;
	}

	@Override
	public UserInfoVO selecUserCheckId(UserInfoVO user) {
		String sql = "select ui_id from user_info where ui_id=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUi_id());
			rs = ps.executeQuery();
			if(rs.next()) {
				UserInfoVO ui = new UserInfoVO();
				ui.setUi_id(rs.getString("ui_id"));
				return ui;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			InitServlet.close(rs, ps, con);
		}
		return null;
	}

	@Override
	public UserInfoVO selecUserCheckNickName(UserInfoVO user) {
		String sql = "select ui_nickname from user_info where ui_nickname=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUi_nickname());
			rs = ps.executeQuery();
			if(rs.next()) {
				UserInfoVO ui = new UserInfoVO();
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
