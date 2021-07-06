package com.itwillbs.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class BoardDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class); 
	
	@Inject
	private BoardDAO dao;
	
	@Test
	public void createTest() throws Exception {
		//글쓰기 테스트
		BoardVO vo = new BoardVO();
		vo.setTitle("1번 글 테스트");
		vo.setContent(" 글 내용11111");
		vo.setWriter("admin");
		
		dao.create(vo);
	}
}
