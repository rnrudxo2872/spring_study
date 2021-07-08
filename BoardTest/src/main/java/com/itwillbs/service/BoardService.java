package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardService {
	
	//글쓰기
	public void regist(BoardVO vo) throws Exception;
	
	//글 전체 목록 가져오기
	public List<BoardVO> listALL() throws Exception;
	
	//글 조회
	public BoardVO read(int bno) throws Exception;
	
	//글 수정
	public void modify(BoardVO vo) throws Exception;
	
	//글 삭제
	public void remove(Integer bno) throws Exception;
}
