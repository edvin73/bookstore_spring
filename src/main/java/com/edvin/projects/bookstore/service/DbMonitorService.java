package com.edvin.projects.bookstore.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DbMonitorService {
	
	private Logger logger = LoggerFactory.getLogger(DbMonitorService.class);
	
	private final DBChecker dbChecker;
	
	public DbMonitorService(OracleDbChecker dbChecker) {
		this.dbChecker = dbChecker;
	}
	
	@Scheduled(fixedRate = 600000) // Check every 10 minutes)
	public void  isDbAvailable() {
		boolean isUp =  dbChecker.isDbAvailable();
		
		if (isUp) {
			logger.info("Database is up and running. " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		} else {
			logger.warn("Database is not available. " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		}
	}
	
	
	@Scheduled(cron = "0 */15 * * 8 SAT-SUN") // every 30 minutes
	public void checkDbWithCron() {
	    logger.info("Cron-based DB check at {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}


}
