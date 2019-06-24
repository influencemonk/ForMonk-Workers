package com.formonk.workers.dao;

import com.ForMonk2.model.InstagramAnalyticsLogsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InstagramAnalyticsLogsDao implements MongoRepository<InstagramAnalyticsLogsModel , String> {
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public <S extends InstagramAnalyticsLogsModel> S save(S s) {
        return mongoTemplate.insert(s);
    }

    @Override
    public <S extends InstagramAnalyticsLogsModel> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<InstagramAnalyticsLogsModel> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<InstagramAnalyticsLogsModel> findAll() {
        return null;
    }

    @Override
    public Iterable<InstagramAnalyticsLogsModel> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(InstagramAnalyticsLogsModel instagramAnalyticsLogsModel) {

    }

    @Override
    public void deleteAll(Iterable<? extends InstagramAnalyticsLogsModel> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<InstagramAnalyticsLogsModel> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<InstagramAnalyticsLogsModel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends InstagramAnalyticsLogsModel> S insert(S s) {
        return mongoTemplate.insert(s);
    }

    @Override
    public <S extends InstagramAnalyticsLogsModel> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends InstagramAnalyticsLogsModel> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends InstagramAnalyticsLogsModel> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends InstagramAnalyticsLogsModel> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends InstagramAnalyticsLogsModel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends InstagramAnalyticsLogsModel> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends InstagramAnalyticsLogsModel> boolean exists(Example<S> example) {
        return false;
    }
}
