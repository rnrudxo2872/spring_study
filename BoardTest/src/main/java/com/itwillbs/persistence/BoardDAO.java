package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {
	
	// 글쓰기(create)
	public void create(BoardVO vo) throws Exception;

	// 모든 글조회(select)
	public List<BoardVO> listALL() throws Exception;
	
	//글 조회(select)
	public BoardVO read(Integer bno) throws Exception;
	
	//글 수정(update)
	public void modify(BoardVO vo) throws Exception;
	
	//글 삭제(delete)
	public void remove(Integer bno) throws Exception;
}
