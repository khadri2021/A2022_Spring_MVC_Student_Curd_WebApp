package com.khadri.spring.mvc.jdbc.sequence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.jdbc.connection.JdbcConnection;

@Component
public class CustomSequence {

//	@Autowired
//	JdbcConnection jdbcConnection;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Integer getSequence() {
	 
		String sql = "select max(STUD_ID) from student_register";
		Integer seq = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println("Exiting Seq "+seq);
		
		return seq +1;

	}

}
