package com.formonk.workers.dao;


import com.ForMonk2.utils.Constants;
import com.formonk.workers.models.GetUniqueAuthTokens;
import com.monkoauth.model.SocialMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Component
public class SocialMasterDao implements MongoRepository<SocialMaster, String> {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public <S extends SocialMaster> S save(S s) {
        return null;
    }

    @Override
    public <S extends SocialMaster> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<SocialMaster> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<SocialMaster> findAll() {
        return null;
    }

    @Override
    public Iterable<SocialMaster> findAllById(Iterable<String> iterable) {
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
    public void delete(SocialMaster socialMaster) {

    }

    @Override
    public void deleteAll(Iterable<? extends SocialMaster> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<SocialMaster> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<SocialMaster> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends SocialMaster> S insert(S s) {
        return null;
    }

    @Override
    public <S extends SocialMaster> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends SocialMaster> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends SocialMaster> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends SocialMaster> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends SocialMaster> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends SocialMaster> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends SocialMaster> boolean exists(Example<S> example) {
        return false;
    }

    public List<GetUniqueAuthTokens> getUniqueAuthTokens(){
       try{
           String clientId = Constants.SOCIAL_CLIENTS.INSTAGRAM;
           AggregationOperation validClientIds = Aggregation.match(new Criteria().andOperator(
                   Criteria.where("clientId").is(clientId),
                   Criteria.where("expiryDate").lte(Instant.now()
                   )));

           AggregationOperation groupBySocialhandle = Aggregation
                   .group("socialHandleId")
                   .last("accessToken")
                   .as("accessToken");
           Aggregation aggregation = Aggregation.newAggregation(validClientIds, groupBySocialhandle);
           AggregationResults<GetUniqueAuthTokens> results = mongoTemplate.aggregate(
                   aggregation ,
                   "SocialMaster" ,
                   GetUniqueAuthTokens.class);
           return results.getMappedResults();
       }catch (Exception e){
           return  null;
       }

    }
}
