package com.itwillbs.web;

import java.util.List;

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
	//<context:component-scan base-package="com.itwillbs.persistence" />로 repository 찾음
	@Inject
	private MemberDAO mDAO;
	
	//@Test
	public void testDAO() {
		System.out.println("객체확인 ====: " + mDAO);
	}

	//DAO 객체 메서드 호출(시간정보 가져오는 메서드)
	//@Test
	public void testGetTime() {
		System.out.println("Model-Action페이지 ");
		
		System.out.println("시간정보 : " + mDAO.getTime());
		
		System.out.println("--------------------------------------");
	}
	
	//@Test
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
	
	//@Test
	public void testGetMember() {
		System.out.println("멤버 정보 가져오기");
		MemberVO mVO = mDAO.getMember("Koo");
		System.out.println(mVO.toString());
	}
	
	//@Test
	public void testUpdateMember() {
		System.out.println("회원정보 수정하기");
		
		MemberVO updateVO = new MemberVO();
		updateVO.setUserid("Koo");
		updateVO.setUserpw("wefw");
		updateVO.setUsername("경태라구요");
		updateVO.setUseremail("Koo@gamil.com");
		
		// DAO 객체를 주입
		mDAO.updateMember(updateVO);
	}
	
	//@Test
	public void testDeleteMember() {
		System.out.println("회원정보 삭제하기");
		
		MemberVO deleteVO = new MemberVO();
		deleteVO.setUserid("wefw");
		deleteVO.setUserpw("wefw");
		
		mDAO.deleteMember(deleteVO);
		System.out.println("==========테스트 종료============");
	}
	
	
	//로그인 처리
	//@Test
	public void testLogin() {
		
		String loginID = "Koo";
		String loginPW = "wefefw";
		
		// id, pw에 해당하는 회원정보가 있을 경우 - 로그인 성공
		// 			" 					없을 경우 - 로그인 실패
		
		MemberVO loginVO =  mDAO.LoginMember(loginID, loginPW);
		
		if(loginVO != null) {
			System.out.println("TEST : 로그인 성공!");
		
		}else {
			System.out.println("TEST : 로그인 실패!");
		}
		
	}

	//회원 전체 목록 조회
	@Test
	public void testMemberList() {
		List<MemberVO> memberList = mDAO.getMemberList();
		System.out.println("TEST : " + memberList);
	}
	
}
