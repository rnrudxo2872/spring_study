package com.itwillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;


public class MysqlConnectTest {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	//8.0~ "com.mysql.cj.jdbc.Driver"
	
	private static final String DBURL = "jdbc:mysql://localhost:3306/springdb?useSSL=false";
	//8.0~ ""jdbc:mysql://localhost:3306/springdb?useSSL=false&serverTimezone=Asia/Seoul"
	
	private static final String DBID="root";
	private static final String DBPW = "1234";

	// Junit사용 테스트
	//@Test
	public void testCon() {
		try {
			Class.forName(DRIVER);
			Connection con = (Connection)DriverManager.getConnection(DBURL, DBID, DBPW);
			System.out.println("디비 연결 : " + DBURL);
		} catch (ClassNotFoundException e) {
			//TODO: handle exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testCon2() throws ClassNotFoundException {
		
		// try - with : 1.7이상의 자바에서 사용
		// 자원해제 구문을 포함하는 예외처리
//		try(AutoCloseable ef) {
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
			Class.forName(DRIVER);
			
			try(Connection con = (Connection)DriverManager.getConnection(DBURL, DBID, DBPW)){
				System.out.println("디비 연결 성공! : " + con);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}
