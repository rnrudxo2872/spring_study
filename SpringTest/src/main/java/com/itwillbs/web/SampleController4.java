package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	@RequestMapping("/doD")
	//public String doD(@ModelAttribute("msg") String wan) {
	public String doD(RedirectAttributes rttr) {
		logger.info("doD 호출");
		
		rttr.addFlashAttribute("msg", "1회성 데이터 전달이래요~ 아메리카노 부대찌개 떡볶이");
		
		//	return "/doE"; doE.jsp 뷰페이지 연결
		return "redirect:/doE"; //특정페이지로 이동(다른 메서드 호우)
		//return "forward:/doE";
	}
	@RequestMapping("/doE")
	public void doE(@ModelAttribute("msg") String msg) {
		logger.info("doE 호출");
		logger.info(msg);
		
	}
	
	// *RedirectAttributes 객체 : 리다이렉트 페이지 이동시 사용가능한 객체
	// 페이지간에 데이터 전달가능(Model 기능 유사)
	
	//rttr.addFlashAttribute("msg", "1회성 데이터");
	
	
	//rttr.addAttribute();  :   URI에 표시O, F5시 데이터 있음
	//rttr.addFlashAttribute();  :   URI에 표시X, F5시 데이터 없음(1회성)
	
	
	
}
