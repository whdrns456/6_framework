package com.kh.spring.board.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.model.vo.PageInfo;

import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor 로도 처리 가능하다 (lombok 이용)
@Service
public class BoardServiceImpl implements BoardService {
	
	// sqlSession, dDao 객체 
	
	private final SqlSessionTemplate sqlSession;
	private final BoardDao bDao;
	
	public BoardServiceImpl(SqlSessionTemplate sqlSession, BoardDao bDao){
		this.sqlSession = sqlSession;
		this.bDao = bDao;
	}
	
	@Override
	public int selectListCount() {
		return bDao.selectListCount(sqlSession);
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		return bDao.selectListCount(sqlSession, pi);
		
	}

	@Override
	public ArrayList<Board> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBoard(Board b) {
		
		
		return bDao.insertBoard(sqlSession, b);
	}

	@Override
	public int increaseCount(int boardNo) {
		
		return bDao.increaseCount(sqlSession,boardNo);
	}

	@Override
	public Board selectBoard(int boardNo) {
		
		return bDao.selectBoard(sqlSession,boardNo);
	}

	@Override
	public int updateBoard(Board b) {
		
		return bDao.updateBoard(sqlSession, b);
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return bDao.deleteBoard(sqlSession,boardNo);
	}

	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {
		return bDao.selectReplyList(sqlSession, boardNo);
		 
	}

	@Override
	public int insertReply(Reply r) {
		
		return bDao.insertReply(sqlSession, r);
	}

	@Override
	public ArrayList<Board> selectBoardTop5() {
		
		return bDao.selectBoardTop5(sqlSession);
	}
	
	

}
