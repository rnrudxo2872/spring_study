package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	// 디비연결/자원해제 객체 - SqlSession
	
	@Inject
	private SqlSession sqlSession;
	
	//mapper주소
	private final static String namespace = "com.itwillbs.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		
		sqlSession.insert(namespace + ".create",vo);
	}

	@Override
	public List<BoardVO> listALL() throws Exception {
		return sqlSession.selectList(namespace + ".listALL");
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return sqlSession.selectOne(namespace + ".read", bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		sqlSession.update(namespace + ".modify", vo);
	}

	@Override
	public void remove(Integer bno) throws Exception {

		sqlSession.delete(namespace + ".remove", bno);
	}
	
}
