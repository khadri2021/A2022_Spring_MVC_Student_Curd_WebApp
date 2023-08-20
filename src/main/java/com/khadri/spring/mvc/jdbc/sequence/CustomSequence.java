package com.khadri.spring.mvc.jdbc.sequence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.jdbc.connection.JdbcConnection;

@Component
public class CustomSequence {

	@Autowired
	JdbcConnection jdbcConnection;

	public Integer getSequence() {
		Integer seq = null;

		Connection con = jdbcConnection.createConnection();

		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select max(STUD_ID) from student_register");
			if (result.next()) {
				seq = result.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Exiting Seq "+seq);
		return seq +1;

	}

}
