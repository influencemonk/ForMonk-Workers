package com.formonk.workers.schedulers;

import com.ForMonk2.model.InstagramAnalyticsLogsModel;
import com.ForMonk2.model.InstagramMediaResponse;
import com.ForMonk2.utils.NetworkHandler;
import com.formonk.workers.Utils.Constants;
import com.formonk.workers.models.GetUniqueAuthTokens;
import com.google.gson.Gson;
import com.formonk.workers.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstaAnalyticsService {

    @Autowired
    SocialMasterDao socialMasterDao;

    @Autowired
    InstagramAnalyticsLogsDao instagramAnalyticsLogsDao;

    @Scheduled(fixedDelay = 12 * 60 * 60 * 1000)
    public void executeService() {
        List<GetUniqueAuthTokens> tokens = socialMasterDao.getUniqueAuthTokens();
        if (tokens == null || tokens.isEmpty())
            return;

        tokens.parallelStream().forEach(token -> {
            InstagramMediaResponse mediaData = getInstagramMedia(token.getSocialHandleId() , token.getAccessToken());
          //  synchronized (InstaAnalyticsService.class) {
                if(mediaData != null ) {
                    double engagement = getEngagementFromPost(mediaData);
                    double averageComments = getAverageComments(mediaData);
                    double averageLikes = getAverageLikes(mediaData);
                    double followersCount = mediaData.getFollowers_count();
                    double followingCount = mediaData.getFollows_count();

                    InstagramAnalyticsLogsModel analyticsModel = new InstagramAnalyticsLogsModel();
                    analyticsModel.setSocialHandleId(token.getSocialHandleId());
                    analyticsModel.setImcId(mediaData.getIMCId());
                    analyticsModel.setFollowersCount((int) followersCount);
                    analyticsModel.setFollowingCount((int) followingCount);
                    analyticsModel.setAverageLikes((int) averageLikes);
                    analyticsModel.setAverageComments((int) averageComments);
                    analyticsModel.setAverageEngagement((int) engagement);
                    analyticsModel.setMediaCount(mediaData.getMedia_count());
                    instagramAnalyticsLogsDao.insert(analyticsModel);
               //    }
            }
        });

    }

    private double getEngagementFromPost(InstagramMediaResponse mediaResponse) {
        List<InstagramMediaResponse.InstagramPostMediaData> data = mediaResponse.getMedia().getData();
        try{
            long totalEngagement =  data.stream().map(x -> x.getInsights()
                    .getData()
                    .stream()
                    .filter(y -> y.getName().equals("engagement"))
                    .collect(Collectors.toList())
                    .get(0)
                    .getInsightValues().get(0).getValue()).reduce(0L , (a, b) -> a + b);
            return totalEngagement / mediaResponse.getMedia().getData().size();
        }catch (Exception e ){
            return 0L;
        }
    }

    private static double getAverageLikes(InstagramMediaResponse instagramMediaResponse) {
        return instagramMediaResponse
                .getMedia()
                .getData()
                .stream()
                .map(x -> x.getLike_count())
                .reduce(0, (a, b) -> a + b);

    }

    private static double getAverageComments(InstagramMediaResponse instagramMediaResponse) {
        return instagramMediaResponse
                .getMedia()
                .getData()
                .stream()
                .map(x -> x.getComments_count())
                .reduce(0, (a, b) -> a + b);

    }

    private InstagramMediaResponse getInstagramMedia(String instagramBusinessId, String authToken) {
        HashMap params = new HashMap();
        params.put("instaBusinessAccountId", instagramBusinessId);
        params.put("authToken", authToken);

        try {
            String response = NetworkHandler
                    .getInstance()
                    .sendGet(Constants.FORMONK_ENDPOINT + "/MonkLinks/v1/getInstagramPosts", params);

            return new Gson().fromJson(response, InstagramMediaResponse.class);
        } catch (Exception e) {
        }
        return null;
    }

}
