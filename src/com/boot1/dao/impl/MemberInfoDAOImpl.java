package com.boot1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.boot1.dao.MemberInfoDAO;
import com.boot1.servlet.InitServlet;
import com.boot1.vo.MemberInfoVO;

public class MemberInfoDAOImpl implements MemberInfoDAO {

	@Override
	public int selectTotalCount(MemberInfoVO mi) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(1) from member_info";
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch(SQLException e) {
			
		}finally {
			InitServlet.close(rs,ps,con);
		}
		return 0;
	}

	@Override
	public List<MemberInfoVO> selectMemberInfoList(MemberInfoVO mi) {
		List<MemberInfoVO> memberList = new ArrayList<>();	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select rownum rnum, mi.* from(select * from member_info order by mi_num desc)mi";
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberInfoVO memberInfoVO = new MemberInfoVO();
				memberInfoVO.setRNum(rs.getInt("rnum"));
				memberInfoVO.setMiNum(rs.getInt("mi_num"));
				memberInfoVO.setMiName(rs.getString("mi_name"));
				memberInfoVO.setMiId(rs.getString("mi_id"));
				memberList.add(memberInfoVO);
			}
			return memberList;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			InitServlet.close(rs, ps, con);
		}
		return null;
	}
	public static void main(String[] args) {
		InitServlet is = new InitServlet();
		is.init();
		MemberInfoDAO memberInfoDAO = new MemberInfoDAOImpl();
		System.out.println(memberInfoDAO.selectMemberInfoList(null));
		System.out.println(memberInfoDAO.selectTotalCount(null));
	}
}
