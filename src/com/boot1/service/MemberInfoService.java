package com.boot1.service;

import java.util.Map;

import com.boot1.vo.MemberInfoVO;

public interface MemberInfoService {
	Map<String,Object> selectMemberInfoList(MemberInfoVO mi);
}
