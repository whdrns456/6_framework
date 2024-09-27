package com.kh.mybatis.member.service;

import com.kh.mybatis.member.*;
import com.kh.mybatis.member.model.vo.Member;

public interface MemberService {
		
	// 인터페이스 : 추상메소드 (publc abstract) + 상수(public static fimla)
	
	/* 로그인 요청 관련 기능 */
	Member loginMember(Member m);
	
	
	/* 회원가입 요청*/ 
	int insertMember(Member m);	
	
	/*회원정보수정*/
	Member updateMember(Member m);
	
	/*탈퇴 요청 관련 기능*/
	int deleteMember(String id, String pwd);
	
	
	
	
	
}
