package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml"
		)
public class MemberServiceTest {

	@Inject
	private MemberService service;
	
	@Test
	public void testInsertMemberS() {
		try {
			MemberVO vo = new MemberVO();
			vo.setUserid("test");
			vo.setUserpw("1234");
			vo.setUsername("홍길동");
			vo.setUseremail("hong@naver.com");
			
			
			service.insertMember(vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
