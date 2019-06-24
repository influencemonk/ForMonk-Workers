package com.formonk.workers.schedulers;

import com.ForMonk2.utils.NetworkHandler;
import com.formonk.workers.Utils.Constants;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
public class InstaAnalyticsService {
    public static void executeService(){
        HashMap params = new HashMap();
        params.put("authToken" , "EAAKZBFNc92isBABhycuaZA4IZA09sIpFYAsl0coTLYv7ZA7iBaqSz8UtmZBsiMbNfLLplgK4ZBZBchZB5oefAiqATMELwjX22CaZAH1IwLXuvZBw12ZAecjOBEvFw4S8PZAZBp9u0aaos2azW24nxkgl7M1AjbUdGQsBY6ZCit9bcfDgrxhd00w46nIk4gubhYnoLZBrk1gobTWgYuKvQZDZD");
        params.put("instaBusinessAccountId" ,"17841409045991210");
        try {
            String response = NetworkHandler.getInstance().sendGet(Constants.FORMONK_ENDPOINT , params);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
