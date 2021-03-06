package com.itwillbs.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
// => 해당 테스트 코드를 실행할 때 스프링으로 처리되도록 설정 (없으면 자바로하는거임)

//@ContextConfiguration(
//		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
//		)
// => 테스트시 필요한 설정을 지정 (root-context.xml)

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {
	
	//디비 연결 -> 디비객체 필요 => 디비객체를 의존하고 있다.
	// => 의존 주입(DI 통해서)
	@Inject
	private DataSource ds;
	
	// 테스트 동작은 반드시 @Test 붙혀놔야함
	@Test
	public void testDS() {
		System.out.println("DataSource 객체 생성여부 확인 메서드 ");
		System.out.println(ds);
	}
	
	@Test
	public void testCon() throws SQLException {
		System.out.println("DB 연결 메서드");
		
		Connection con = ds.getConnection();
		
		System.out.println("디비 연결 성공 : " + con);
	}
}
