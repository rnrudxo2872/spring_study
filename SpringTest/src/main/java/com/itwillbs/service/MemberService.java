package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	
	// 실행해야하는 동작을 구현 (사용자 요구사항)
	
	// 회원가입 처리 동작
	public void insertMember(MemberVO vo) throws Exception;
	
}
