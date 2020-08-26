package com.boot1.dao;

import java.util.List;

import com.boot1.vo.MemberInfoVO;

public interface MemberInfoDAO {
	int selectTotalCount(MemberInfoVO mi);
	List<MemberInfoVO> selectMemberInfoList(MemberInfoVO mi);
		
}
