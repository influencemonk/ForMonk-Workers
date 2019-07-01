package com.formonk.workers.models

import lombok.Data
import org.bson.codecs.pojo.annotations.BsonProperty

@Data
class GetUniqueAuthTokens {
    @BsonProperty("_id")
    val socialHandleId: String? = null //this is the socialHandleId
    var accessToken: String? = null
        set(accessToken) {
            field = this.accessToken
        }
}
