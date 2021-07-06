package com.itwillbs.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	// 글쓰기 동작
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String registGET() throws Exception{
		return "/board/regist";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPOST(BoardVO vo, RedirectAttributes rttr) throws Exception{
		logger.info("포스트");
		
		// 입력정보를 전달받아서 DB에 정보를 저장 => 서비스동작을 호출
		
		logger.info(vo+"");
		
		service.regist(vo);
		
		logger.info("글쓰기 완료!");
		
		rttr.addFlashAttribute("result", "success");
		
		//return "/board/success"; ==> 양식 다시 제출... 디비에 쌓임 
		return "redirect:/board/listAll";
	}
	
	//리스트 페이지 (get)
	@RequestMapping( value = "/listAll", method=RequestMethod.GET)
	public void listAll(Model model, @ModelAttribute("result") String result) throws Exception {
		logger.info("C : listAllGET() 호출");
		logger.info("C : 전달정보 " + result);
		
		// 서비스를 통해서 DB에 있는 모든 글정보 가져오기
		model.addAttribute("boardList", service.listALL());
	}
}
