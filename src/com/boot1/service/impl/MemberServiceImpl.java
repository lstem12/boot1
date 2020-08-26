package com.boot1.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boot1.dao.MemberInfoDAO;
import com.boot1.dao.impl.MemberInfoDAOImpl;
import com.boot1.service.MemberInfoService;
import com.boot1.servlet.InitServlet;
import com.boot1.vo.MemberInfoVO;

public class MemberServiceImpl implements MemberInfoService {
	private MemberInfoDAO memberInfoDAO = new MemberInfoDAOImpl();
	@Override
	public Map<String,Object> selectMemberInfoList(MemberInfoVO memberInfoVO) {
		int page = memberInfoVO.getPage();
		int startRowNum = (page-1)*10 +1;
		int endRowNum = startRowNum + (10-1);
		memberInfoVO.setStartRowNum(startRowNum);
		memberInfoVO.setEndRowNum(endRowNum);
		List<MemberInfoVO> memberList = memberInfoDAO.selectMemberInfoList(memberInfoVO);
		int totalCount = memberInfoDAO.selectTotalCount(memberInfoVO);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("list", memberList);
		rMap.put("totalCnt",totalCount);
		return rMap;
	}
	public static void main(String[] args) {
		InitServlet is = new InitServlet();
		is.init();
		MemberInfoService mis = new MemberServiceImpl();
		MemberInfoVO mi = new MemberInfoVO();
		mi.setPage(3);
		System.out.print(mis.selectMemberInfoList(mi));
	}
}
