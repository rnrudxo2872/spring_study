package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberDAOTest {

	//DAO객체 생성 (의존관계)
	//private MemberDAO mDAO = new MemberDAOImpl(); => 강한결합
	@Inject
	private MemberDAO mDAO;
	
	@Test
	public void testDAO() {
		System.out.println("객체확인 ====: " + mDAO);
	}

	//DAO 객체 메서드 호출(시간정보 가져오는 메서드)
	@Test
	public void testGetTime() {
		System.out.println("Model-Action페이지 ");
		
		System.out.println("시간정보 : " + mDAO.getTime());
		
		System.out.println("--------------------------------------");
	}
	
	@Test
	public void testInsertMember() {
		System.out.println("회원가입 메서드 동작");
		System.out.println(" DAO-insertMember() 메서드 호출");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("Koo");
		vo.setUseremail("qweqww");
		vo.setUserpw("wefw");
		vo.setUsername("쿠쿠경태");
		
		mDAO.insertMember(vo);
	}
}