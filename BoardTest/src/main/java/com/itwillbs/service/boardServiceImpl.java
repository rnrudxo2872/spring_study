package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class boardServiceImpl implements BoardService{
	// 디비 - 서비스 - 컨트롤러
	
	// DAO 객체 생성 => 주입
	@Inject
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public List<BoardVO> listALL() throws Exception {
		
		return dao.listALL();
	}
}
