package com.itwillbs.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DBTest {
	
	private final Logger logger = LoggerFactory.getLogger(DBTest.class);
	
	@Inject
	private DataSource ds;
	
	@Test
	public void test() throws Exception {
		logger.info("여기");
		Connection conn = ds.getConnection();
		logger.info(""+conn);
	}
}
