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
		String sql = "select * from(select rownum rnum, mi.* from(\r\n" + 
				"	select * from member_info\r\n" + 
				"	order by mi_num desc\r\n" + 
				") mi\r\n" + 
				"where rownum <=? )\r\n" + 
				"where rnum>=?";
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, mi.getEndRowNum());
			ps.setInt(2, mi.getStartRowNum());
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
		MemberInfoVO memberInfoVO = new MemberInfoVO();
		memberInfoVO.setEndRowNum(40);
		memberInfoVO.setStartRowNum(21);
		System.out.println(memberInfoDAO.selectMemberInfoList(memberInfoVO));
		System.out.println(memberInfoDAO.selectTotalCount(null));
	}
}
