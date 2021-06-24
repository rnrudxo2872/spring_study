package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController3 {

	private final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	//view 페이지로 객체정보 전달
	@RequestMapping("/doC")
	public String doC(Model model) {
		//Model객체 : Spring에서 제공하는 기본 MVC 
		// 뷰에 데이터를 전달하는 컨테이너(상자) 역할 클래스
		
		logger.info("doC() 메서드 호출!");
		logger.info("productDetail.js 페이지로 이동");
		
		//model.addAttribute("test","1234");
		
		ProductVO vo = new ProductVO("컴퓨터",100);
		model.addAttribute("vo", vo);
		
		//key값이 없기 때문에 전달되는 타입의 클래스명, 첫글자만 소문자로 변경해서
		//key값으로 사용가능
		model.addAttribute(vo);
		
		return "productDetail";
	}
}
