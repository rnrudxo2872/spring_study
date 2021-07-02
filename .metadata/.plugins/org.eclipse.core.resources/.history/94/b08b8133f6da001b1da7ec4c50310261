package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	
	// 실행해야하는 동작을 구현 (사용자 요구사항)
	
	// 회원가입 처리 동작
	public void insertMember(MemberVO vo) throws Exception;
	
	// 로그인 체크 동작
	public MemberVO loginMember(MemberVO vo) throws Exception;
	public MemberVO loginMember(String userID, String userPW) throws Exception;
	
	
	//회원정보 조회 동작(info)
	public MemberVO infoMember(String userid) throws Exception;
	
	// 회원정보 수정 동작
	public void updateMember(MemberVO vo) throws Exception;
}
