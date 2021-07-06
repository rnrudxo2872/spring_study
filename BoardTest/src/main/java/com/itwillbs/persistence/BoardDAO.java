package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {
	
	// 글쓰기(create)
	public void create(BoardVO vo) throws Exception;

	// 모든 글조회(select)
	public List<BoardVO> listALL() throws Exception;
}
