package com.boot1.vo;

import lombok.Data;

@Data
public class MemberInfoVO {
	private int rNum;
	private int miNum;
	private String miId;
	private String miName;
	private int startRowNum;
	private int endRowNum;
	private int page;
	private String cmd;
}
