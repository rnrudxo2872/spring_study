package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tt")
public class SampleController {
	
	//AOP라 생각할 수 있다. system.out은 시스템을 부르는거기 때문에 많이 하면 성능 저하가 될 수 있음.
	//Logger는 따로이기 때문에(system과) ㄱㅊ
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	//http://localhost:8088/web/tt/doA
	//컨트롤에서의 동작은 메서드로 구현
	@RequestMapping(value="/doA")
	public void doA() {
		logger.info(" 출력하기11111111111111111111111111111");
		logger.info("doA 호출~~!~!~!~!~");
	}
	
	//http://localhost:8088/web/tt/doA2
	@RequestMapping("/doA2")
	public String doA1() {
		logger.info("doA2() 메서드 호출~!~!");
		
		return "doA2";
	}
	
	// * 컨트롤러의 동작 메서드 리턴타입이 void인 경우
	// 매핑된 주소.jsp 페이지를 호출
	// * view 폴더안에 있는 파일을 사용
}
