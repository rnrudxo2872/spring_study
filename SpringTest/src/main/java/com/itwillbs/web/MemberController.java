package com.itwillbs.web;

import java.net.Authenticator.RequestorType;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		
		// 페이지 이동(login페이지로 리다이렉트)
		return "redirect:./login";
	}
	
	//login(get)
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() throws Exception{
		logger.info("C : === 로그인 Form ===");
		logger.info("C : login view 페이지로 이동");
		return "./member/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(MemberVO vo, HttpSession session) throws Exception {
		
		logger.info("C : loginPOST() 호출");
		
		//DB에 회원정보가 잇는지 체크
		// O => 메인페이지, 로그인 세션 생성
		// X => 다시 로그인페이지로 이동
		
		logger.info("얻은 파라미터 -> " + vo);
		
		// 서비스 동작 -> DAO -> (MyBatis)mapper -> DB
		logger.info("C : 서비스 - loginMember() 호출");
		MemberVO loginVO = service.loginMember(vo);
		
		//비회원/비밀번호 오류
		//로그인 페이지로 다시 이동
		if(loginVO == null) {
			return "redirect:./login";
		}
		
		// 회원 동작 처리
		// 로그인 세션처리 (jsp 뷰 페이지에서 세션객체 전달받아서 처리)
		session.setAttribute("id", loginVO.getUserid());
		
		// 페이지 이동
		return "redirect:./main";
	}
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public void mainGET() {
		logger.info("C : main view 호출");
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutGET(HttpSession session) {
		session.invalidate();
		return "redirect:./main";
	}
	
	@RequestMapping(value="/info", method = RequestMethod.GET)
	public String infoGET(HttpSession session, Model model) throws Exception{
		
		logger.info("C : infoGET() 호출");
		
		String userid = (String)session.getAttribute("id");
		if(userid == null) {
			return "redirect:./login";
		}
		
		//DB 회원정보를 가져오는 동작
		MemberVO infoVO = service.infoMember(userid);
		
		logger.info("=====================>"+infoVO);
		model.addAttribute("infoVO", infoVO);
		
		//DB 회원정보를 view 페이지로 이동
		return "/member/info";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateGET(HttpSession session, Model model) throws Exception{
		logger.info("update 호출");
		String userid = (String) session.getAttribute("id");
		
		if(userid == null) {
			return "redirect:./login";
		}
		
		MemberVO infoVO = service.infoMember(userid);
		model.addAttribute("infoVO", infoVO);
		
		return "/member/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePOST(MemberVO vo) throws Exception{
		logger.info("C : updatePOST() 호출");
		
		// 전달된 수정할 정보저장
		// DB이동 위한 서비스객체 주입
		service.updateMember(vo);
		
		// 페이지 이동(main.jsp)
		
		return "redirect:/member/main";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String deleteGet() throws Exception{
		logger.info("C: deleteGET() 호출");
		
		return "/member/deleteForm";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String deletePOST(MemberVO vo, HttpSession session) throws Exception{
		logger.info("C: deletePOST() 호출");
		
		int result = service.deleteMember(vo);
		
		if(result != 1) {
			return "redirect:./delete";
		}
		
		//세션 초기화
		session.invalidate();
		
		//메인페이지 이동
		return "redirect:./main";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String listGet(Model model) throws Exception{
		logger.info("C: listGET() 호출");
		
		List<MemberVO> memberList = service.memberList();
		model.addAttribute("memberList", memberList);
		
		return "/member/list";
	}
}
