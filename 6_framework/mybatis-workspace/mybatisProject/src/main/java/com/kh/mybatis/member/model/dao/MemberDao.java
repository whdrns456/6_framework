package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	public Member loginMember(SqlSession sqlSession, Member m) {
	
		Member loginUser = null; 
	
		loginUser = sqlSession.selectOne("memberMapper.LoginMember",m);
		// selectOne() : 조회된 결과가 없을 경우 nulldmf 반환 
		return loginUser;
	}
	
	public int insertMember(SqlSession sqlSession, Member m) {
		return sqlSession.insert("memberMapper.insertMember",m);
	}
	/* 
	 * sqlSession 객체에서 제공하는 메소드를 통해 sql문을 실행하고 결과를 바로 받음 
	 * 
	 * 결과 = sqlSession.SQL문 종류에 맞는 메소드("매퍼의별칭.sql문의 id[, sql문 실행 시 필요한 데이터]")
	 * 
	 */

	public int idCheck(SqlSession sqlSession, String userId) {
		int result = sqlSession.selectOne("memberMapper.idCheck",userId);
		
		return result;
	}
	
}
