package com.kh.spring.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.model.vo.Member;

@Repository 	    	// DB와 직접적인 하는 클래스에 사용
public class MemberDAO {
	
	public Member loginMember(SqlSessionTemplate sqlSession, Member m){
	
		// name값 ..조건으로 사용할 값을 객체를 넣는다
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}

	public int insertMember(SqlSessionTemplate sqlSession, Member m) {
		
		return sqlSession.insert("memberMapper.insertMember",m);
	}
	
	

	
	
	
	
	
}
