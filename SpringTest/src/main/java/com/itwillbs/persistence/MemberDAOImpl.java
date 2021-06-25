package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

//@Repository : 스프링에 DAO파일을 인식한다.
//		=>root-context.xml파일에서 해당객체를 bean으로 인식

@Repository
public class MemberDAOImpl implements MemberDAO{
	//DAO 객체
	
	//디비 연결 + 자원해제 객체를 생성 => SqlSessionTemplate가 함
	// => 객체를 주입받아서 사용
	
	@Inject
	private SqlSession sqlSession;
	
	// mapper 주소
	private static final String namespace = "com.itwillbs.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		System.out.println("세션 : ==== " + sqlSession);
		System.out.println("DB-SQL 구문 실행");
		
		System.out.println("sqlSession 객체를 사용해서 mapper 호출 sql 실행");
		String result = sqlSession.selectOne(namespace + ".getTime");
		
		return result;
	}

	@Override
	public void insertMember(MemberVO vo) {
		System.out.println("DAOImpl 객체 - insertMember() 호출");
		System.out.println("SqlSession 객체 생성 -> mapper 접근");
		
		
		//sqlSession.insert(namespace+".insertMember"); ==> sql 쿼리만 실행
		//sqlSession.insert(namespace+".insertMember",Object); ==> sql 쿼리 실행, 쿼리에 필요한 값을 전달
		sqlSession.insert(namespace+".insertMember", vo);
		
		System.out.println("mapper 사용 -> DB 실행 ");
		System.out.println("회원가입 성공");
	}
}
