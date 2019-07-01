package com.formonk.workers

import com.formonk.workers.dao.InstagramAnalyticsLogsDao
import com.formonk.workers.dao.SocialMasterDao
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@EnableMongoRepositories(basePackageClasses = arrayOf(SocialMasterDao::class, InstagramAnalyticsLogsDao::class))
@EnableMongoAuditing
class WorkersApplication
fun main(args: Array<String>) {
	runApplication<WorkersApplication>(*args)
}
