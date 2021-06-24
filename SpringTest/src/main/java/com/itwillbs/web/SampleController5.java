package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController5 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController5.class);
	
	@RequestMapping("doPro1")
	public ProductVO doPro() {
		logger.info("doPro() 호출");
		ProductVO vo = new ProductVO("휴대폰", 200);
		
		return vo;
	}
	
	//JSON 타입 데이터 활용
	@RequestMapping("doPro2")
	public @ResponseBody ProductVO doPro2() {
		logger.info("doPro2 ===");
		
		ProductVO vo = new ProductVO("휴대폰",100);
		
		return vo;
	}
}
