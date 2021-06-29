package com.itwillbs.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

// @Service : 외부에서 해당서비스를 호출시 처리할 수 있도록 등록
//				=> root-context.xml 파일에서 BEAN 형태로 인식

@Service
public class MemberServiceImpl implements MemberService {

	//DAO 객체 생성
	@Inject
	private MemberDAO mDAO;
	
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		
		System.out.println("S : 컨트롤러에서 정보를 받아서 제공");
		System.out.println("S : 회원가입 동작");
		
		mDAO.insertMember(vo);
		
		System.out.println("S : 회원가입 처리 완료");
		System.out.println("S : 컨트롤러로 이동");
	}

}
