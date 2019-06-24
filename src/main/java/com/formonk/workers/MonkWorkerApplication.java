package com.formonk.workers;

import com.formonk.workers.schedulers.InstaAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonkWorkerApplication {


	public static void main(String[] args) {
		SpringApplication.run(MonkWorkerApplication.class, args);
		InstaAnalyticsService.executeService();
	}

}
