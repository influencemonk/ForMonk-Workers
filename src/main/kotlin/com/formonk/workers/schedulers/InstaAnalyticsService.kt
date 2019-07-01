package com.formonk.workers.schedulers

import com.formonk.workers.dao.InstagramAnalyticsLogsDao
import com.formonk.workers.dao.SocialMasterDao
import com.formonk.workers.models.GetUniqueAuthTokens
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class InstaAnalyticsService {

    @Autowired
    internal lateinit var  socialMasterDao: SocialMasterDao

    @Autowired
    internal var instagramAnalyticsLogsDao: InstagramAnalyticsLogsDao? = null;

    val tokens: List<GetUniqueAuthTokens>? by lazy{
        socialMasterDao.uniqueAuthTokens
    }

    @Scheduled(fixedDelay = (12 * 60 * 60 * 1000).toLong())
    internal fun executeService(){

        if (tokens != null ){
            print("Not null")
        }else{
            print("Token is null")
        }
    }
}