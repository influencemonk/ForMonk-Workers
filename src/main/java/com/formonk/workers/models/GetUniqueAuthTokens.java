package com.formonk.workers.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Data
public class GetUniqueAuthTokens {
    @BsonProperty("_id")
    private String _id ; //this is the socialHandleId
    private String accessToken;

    public String getSocialHandleId(){
        return _id;
    }
}
