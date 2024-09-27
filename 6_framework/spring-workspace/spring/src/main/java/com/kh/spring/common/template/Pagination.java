package com.kh.spring.common.template;

import com.kh.spring.common.model.vo.PageInfo;

public class Pagination {

	// --------- 페이징 처리 ----------------
	public static PageInfo getPageInfo(
									int listCount,
									int currentPage
									,int pageLimit
									, int boardLimit
								){
		int maxPage = (int)Math.ceil((double)listCount / boardLimit);
		int startPage = ((currentPage - 1) / pageLimit) * pageLimit + 1; 
		// 페이징바의 시작번호(pageLimit,currentPage)
		// * 페이징바의 목록 10개씩 표시한다는 가정하에 
		int endPage = startPage + pageLimit - 1;
		// endPage => 페이징바의 끝번호 
		endPage = endPage > maxPage ? maxPage : endPage; 
		
		return new PageInfo(listCount, currentPage, 
				pageLimit, boardLimit, maxPage,startPage,endPage);
	}
	
	
}
