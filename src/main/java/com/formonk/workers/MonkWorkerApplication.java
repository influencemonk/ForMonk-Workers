package com.formonk.workers;

import com.formonk.workers.dao.InstagramAnalyticsLogsDao;
import com.monkoauth.dao.SocialMasterDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableMongoRepositories(basePackageClasses = {SocialMasterDao.class , InstagramAnalyticsLogsDao.class})
@EnableMongoAuditing
public class MonkWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonkWorkerApplication.class, args);
	}

}
