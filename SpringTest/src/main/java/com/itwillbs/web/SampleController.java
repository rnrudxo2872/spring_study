package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	//AOP라 생각할 수 있다. system.out은 시스템을 부르는거기 때문에 많이 하면 성능 저하가 될 수 있음.
	//Logger는 따로이기 때문에(system과) ㄱㅊ
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	//컨트롤에서의 동작은 메서드로 구현
	@RequestMapping(value="/doA")
	public void doA() {
		logger.info(" 출력하기11111111111111111111111111111");
	}
}
