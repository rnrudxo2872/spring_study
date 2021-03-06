package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {
	private final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	@RequestMapping(value="doB")
	public void doB () {
		
		logger.info("doB() 호출");
		
		//return "";
	}
	
	@RequestMapping(value="doB1")
	public String doB1() {
		
		return "doB";
	}
	
	//http://localhost:8088/web/doB2?msg=test
	@RequestMapping(value="/doB2")
	public String doB2(@ModelAttribute("msg") String msg,
					   @ModelAttribute("txt") int value) {
		
		logger.info("doB2 호출");
		logger.info("view 페이지로 전달할 정보 : " + msg);
		logger.info("view 페이지로 전달할 정보 : " + value);
		//msg = "test";
		return "result";
	}
}
