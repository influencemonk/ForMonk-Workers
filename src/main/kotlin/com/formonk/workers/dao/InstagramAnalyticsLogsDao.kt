package com.formonk.workers.dao

import com.ForMonk2.model.InstagramAnalyticsLogsModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import java.util.Optional

@Component
class InstagramAnalyticsLogsDao : MongoRepository<InstagramAnalyticsLogsModel, String> {
    override fun <S : InstagramAnalyticsLogsModel?> insert(p0: MutableIterable<S>): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): MutableList<InstagramAnalyticsLogsModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(p0: Sort): MutableList<InstagramAnalyticsLogsModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : InstagramAnalyticsLogsModel?> findAll(p0: Example<S>): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : InstagramAnalyticsLogsModel?> findAll(p0: Example<S>, p1: Sort): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(p0: Pageable): Page<InstagramAnalyticsLogsModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : InstagramAnalyticsLogsModel?> findAll(p0: Example<S>, p1: Pageable): Page<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteById(p0: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll(p0: MutableIterable<InstagramAnalyticsLogsModel>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : InstagramAnalyticsLogsModel?> saveAll(p0: MutableIterable<S>): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : InstagramAnalyticsLogsModel?> findOne(p0: Example<S>): Optional<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun count(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : InstagramAnalyticsLogsModel?> count(p0: Example<S>): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAllById(p0: MutableIterable<String>): MutableIterable<InstagramAnalyticsLogsModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun existsById(p0: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : InstagramAnalyticsLogsModel?> exists(p0: Example<S>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(p0: String): Optional<InstagramAnalyticsLogsModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(p0: InstagramAnalyticsLogsModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : InstagramAnalyticsLogsModel?> insert(p0: S): S {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Autowired
    internal var mongoTemplate: MongoTemplate? = null

    override fun <S : InstagramAnalyticsLogsModel> save(s: S): S {
        return mongoTemplate!!.insert(s)
    }


}
