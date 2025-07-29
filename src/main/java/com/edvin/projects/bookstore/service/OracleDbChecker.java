package com.edvin.projects.bookstore.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@EnableScheduling
public class OracleDbChecker implements DBChecker {
	
	private Logger logger = LoggerFactory.getLogger(OracleDbChecker.class);
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	 
	
	@Value("${spring.datasource.username}")
	private String username;
	
	
	@Value("${spring.datasource.password}")
	private String password;
		
	@Override
	public boolean isDbAvailable() {
		
		boolean dbUp = false;
				
		String request = "SELECT 1 FROM DUAL";
		
		try (Connection conn =  DriverManager.getConnection(dbUrl, username, password);
				PreparedStatement ps = conn.prepareStatement(request);
				ResultSet rs = ps.executeQuery()) {
							 
				while (rs.next()) {
					dbUp = true; // DB is available
				}
				
			
		} catch (SQLException e) {
			// Log the exception and return false
			
			logger.error("Database check failed: {}", e.getMessage());
			dbUp = false; // DB is not available
		} finally {
			
			return dbUp;
		}
	}
	
	

}
