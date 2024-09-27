package com.kh.spring.board.service;

import java.util.ArrayList;

import javax.swing.border.Border;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.model.vo.PageInfo;

public interface BoardService {
	
	/* 게시판 목록 조회 (+ 페이징 처리) */
	int selectListCount();
	
	ArrayList<Board>selectList(PageInfo pi);
	
	/*게시글 작성 --> c (insert) */
	ArrayList<Board>selectList(/*페이징 관련 데이터 전달받을 예정*/);
	
	/* 게시글 작성 --> c (insert) */
	int insertBoard(Board b);
		
	/* 게시글 상세조회 --> R(select) + U (update) */
	int increaseCount(int boardNo); // 조회수 증가 
	Board selectBoard(int boardNo);

	/* U 게시글 수정 */
	int updateBoard(Board b);
	
	// 게시글 삭제 --> u (update)
	int deleteBoard(int boardNo);
	
	// 댓글 목록 조회 --> ajax, R (select)
	ArrayList<Reply>selectReplyList(int boardNo);
	
	// 댓글 등록(작성) --> (ajax), c(insert)
	int insertReply(Reply r);
	
	ArrayList<Board>selectBoardTop5();
	
}
