package com.itwillbs.web;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	static private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//servlet-context랑 root-context가 연결되어 있으므로 inject 가능
	@Inject
	private MemberService service;
	
	// 회원가입 동작
	// 1) 회원정보 입력(get)
	//http://localhost:8088/web/member/insert
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insertMemberGET() throws Exception{
		logger.info("회원가입");
		
		logger.info("주소에 해당하는 view 페이지 연결");
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String inserMemberPOST(MemberVO vo, @ModelAttribute("msg") String msg) throws Exception{
		//메서드의 매개변수로 MemberVO 객체를 생성하면
		//자동으로(스프링 MVC) 전달되는 파라미터의 값을 저장해줌
		
		logger.info("insertMemberPOST 호출");
		//전달된 정보 저장
		
		logger.info(""+vo);
		logger.info(msg);
		
		// 전달받은 정보를 DB에 저장 -> DAO 객체 생성
		//	=> Service 객체 호출 => DAO 호출 => mapper 호출 => DB 실행
		
		service.insertMember(vo);
		
		return "";
	}
}
