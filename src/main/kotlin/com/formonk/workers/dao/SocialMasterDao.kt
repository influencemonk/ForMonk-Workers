package com.formonk.workers.dao


import com.ForMonk2.utils.Constants
import com.formonk.workers.models.GetUniqueAuthTokens
import com.monkoauth.model.SocialMaster
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.AggregationOperation
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component

import java.time.Instant
import java.util.Optional

@Component
class SocialMasterDao : MongoRepository<SocialMaster, String> {
    @Autowired
    internal lateinit var mongoTemplate: MongoTemplate;

    override fun <S : SocialMaster?> saveAll(p0: MutableIterable<S>): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : SocialMaster?> save(p0: S): S {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): MutableList<SocialMaster> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAllById(p0: MutableIterable<String>): MutableIterable<SocialMaster> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : SocialMaster?> findAll(p0: Example<S>, p1: Sort): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(p0: Pageable): Page<SocialMaster> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : SocialMaster?> findAll(p0: Example<S>, p1: Pageable): Page<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : SocialMaster?> insert(p0: S): S {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : SocialMaster?> insert(p0: MutableIterable<S>): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : SocialMaster?> findOne(p0: Example<S>): Optional<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : SocialMaster?> findAll(p0: Example<S>): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val uniqueAuthTokens: List<GetUniqueAuthTokens>?
        get() {
            try {
                val clientId = Constants.SOCIAL_CLIENTS.INSTAGRAM
                val validClientIds = Aggregation.match(Criteria().andOperator(
                        Criteria.where("clientId").`is`(clientId),
                        Criteria.where("expiryDate").gte(Instant.now()
                        )))

                val groupBySocialhandle = Aggregation
                        .group("socialHandleId")
                        .last("accessToken")
                        .`as`("accessToken")
                val aggregation = Aggregation.newAggregation(validClientIds, groupBySocialhandle)
                val results = mongoTemplate!!.aggregate<GetUniqueAuthTokens>(
                        aggregation,
                        "SocialMaster",
                        GetUniqueAuthTokens::class.java)
                return results.mappedResults
            } catch (e: Exception) {
                return null
            }

        }



    override fun findById(s: String): Optional<SocialMaster> {
        return Optional.empty()
    }

    override fun existsById(s: String): Boolean {
        return false
    }


    override fun count(): Long {
        return 0
    }

    override fun deleteById(s: String) {

    }

    override fun delete(socialMaster: SocialMaster) {

    }

    override fun deleteAll(iterable: Iterable<SocialMaster>) {

    }

    override fun deleteAll() {

    }

    override fun findAll(sort: Sort): List<SocialMaster> {
        TODO("not implemented")
    }



    override fun <S : SocialMaster> count(example: Example<S>): Long {
        return 0
    }

    override fun <S : SocialMaster> exists(example: Example<S>): Boolean {
        return false
    }
}
