package com.itwillbs.service;


import java.util.List;

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

	@Override
	public MemberVO loginMember(MemberVO vo) throws Exception {
		System.out.println("S : loginMember(vo) 호출");
		System.out.println("S : DAO-LoginMember(id,pw) 호출시도");
		
		MemberVO loginVO = mDAO.LoginMember(vo.getUserid(), vo.getUserpw());
		
		return loginVO;
	}

	@Override
	public MemberVO loginMember(String userID, String userPW) throws Exception {
		System.out.println("S : loginMember(vo) 호출");
		return mDAO.LoginMember(userID, userPW);
	}

	@Override
	public MemberVO infoMember(String userid) throws Exception {
		System.out.println("S : infoMember(id) 호출");
		return mDAO.getMember(userid);
	}

	@Override
	public void updateMember(MemberVO vo) throws Exception {
		System.out.println("S : updateMember(MemberVO vo) 호출");
		
		mDAO.updateMember(vo);
		
		System.out.println("S : 회원정보 수정 완료!");
	}

	@Override
	public int deleteMember(MemberVO vo) throws Exception {
		System.out.println("S : deleteMember() 호출");
		
		int result = mDAO.deleteMember(vo);
		
		System.out.println("S : 회원 탈퇴 처리 완료!");
		
		return result;
	}

	@Override
	public List<MemberVO> memberList() throws Exception {
		
		System.out.println("S : memberList() 호출");
		
		List<MemberVO> memberList = mDAO.getMemberList();
		
		return memberList;
	}
	
}
