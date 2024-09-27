package com.kh.spring.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.dao.MemberDAO;
import com.kh.spring.member.model.vo.Member;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 	// 필드로 선언된 객체(빈)를 생성자 주입방식으로 주입, lombok 방식
@Service					// Component 보다 좀 더 구체화된 객체 (Service bean으로 등록)
public class MemberServiceImpl implements MemberService {
	
	/*
	 *  * 필드 주입 방식 : 스프링 컨테이너에서 객체를 생성한 후
	 *   @Autowired 사용한 필드에 주입   	
	 */
	
	/*
	@Autowired
	private SqlSessionTemplate sqlSession;
	// SqlSessionTemplate sqlSession = new SqlSessionTemplate sqlSession();
	*/
	
	private final SqlSessionTemplate sqlSession;
	private final MemberDAO mDao;
	
	//	@Autowired
	//	public MemberServiceImpl(SqlSessionTemplate sqlSession, MemberDAO mDao){
	//		this.sqlSession = sqlSession;
	//		this.mDao  = mDao;
	//	} lombok을 사용하지 않을 경우 사용하는 방식 
	// => 생성자 주입 방식 
	
	@Override
	public Member loginMember(Member m) {
		// sqlSession 객체 생성 --> 스프링 컨테이너 생성
		// Dao 객체에 sqlSession, 전달된 데이터 전달하면 요청
		// 트랜잭션 처리 (필요 시 )
		// sqlSession 객체 반납 --> 스르핑 컨테이너에서 처리한다.  
		return mDao.loginMember(sqlSession, m); // 결과 반환. .
	}
	@Override
	public int insertMember(Member m) {
		// 기존에 SqlSession 객체 생성 --> spring에서 처리한다 
		// DAO 객체한테 sqlSession, 데이터전달 DB작업 요청
		return mDao.insertMember(sqlSession, m);
	}
	@Override
	public int idCheck(String id) {

		return 0;
	}
	@Override
	public Member updateMember(Member m) {
		
		return null;
	}
	@Override
	public int deleteMember(String id, String pwd) {
		
		return 0;
	}

}
