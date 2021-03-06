package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// 스프링MVC 형태로 테스트를 하겠다

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
														//어떤폴더든/.xml붙은 파일들
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
		)
public class SampleControllerTest {
	//테스트 파일 => 서버없이 테스트
	
	//서버로 돌리면 컴파일 시간과 서버에 올리는 시간이 오래걸리기에 test로 대신함
	
	private static final Logger logger = LoggerFactory.getLogger(SampleControllerTest.class);
	
	//컨트롤러를 실행하는데 필요한 정보를 주입
	//root-context.xml, servlet-context.xml 에서 주입받는다.
	
	@Inject
	private WebApplicationContext webCTX;
	
	//브라우저에서 요청/응답을 처리하는 객체
	private MockMvc mockMVC;
	
	//테스트 동작전에 필요한 설정을 세팅
	@Before
	public void setup() {
		logger.info("테스트 동작전 mockMVC 객체 생성 전=============" );
		this.mockMVC = MockMvcBuilders.webAppContextSetup(webCTX).build();
		logger.info("테스트 동작전 mockMVC 객체 생성" );
	}
	
	//컨트롤러 동작 테스트
	@Test
	public void testDoA() throws Exception{
		logger.info("testDoA() 메서드 호출!");
		
		mockMVC.perform(MockMvcRequestBuilders.get("doA"));
	}
	
}
