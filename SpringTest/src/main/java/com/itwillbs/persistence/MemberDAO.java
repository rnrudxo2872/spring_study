package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	
	//DB를 사용하는 기능구현
	
	//DB서버의 시간정보를 가져오는 기능
	public String getTime();
	
	//회원정보 가입 기능
	public void insertMember(MemberVO vo);
}
