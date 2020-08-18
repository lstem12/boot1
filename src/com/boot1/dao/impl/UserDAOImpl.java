package com.boot1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.boot1.dao.UserDAO;
import com.boot1.servlet.InitServlet;

public class UserDAOImpl implements UserDAO {

	@Override
	public Map<String, Object> userDAOLogin(Map<String, String> user) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = InitServlet.getConnection();
			String sql = "select ui_num, ui_name, ui_age, ui_birth, ui_id, ui_password, ui_phone, "
					+ "ui_email, ui_credat, ui_nickname from user_info where ui_id=? and ui_password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("ui_id"));
			ps.setString(2, user.get("ui_password"));
			rs = ps.executeQuery();
			if(rs.next()) {
				Map<String,Object> rMap = new HashMap<>();
				rMap.put("ui_name", rs.getString("ui_name"));
				rMap.put("ui_age", rs.getInt("ui_age"));
				rMap.put("ui_birth", rs.getString("ui_birth"));
				rMap.put("ui_id", rs.getString("ui_id"));
				rMap.put("ui_phone", rs.getString("ui_phone"));
				rMap.put("ui_email", rs.getString("ui_email"));
				rMap.put("ui_credat", rs.getString("ui_credat"));
				rMap.put("ui_nickname", rs.getString("ui_nickname"));
				return rMap;				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				InitServlet.close(rs, ps, con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
