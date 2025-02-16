//package com.bloomtech.repositories;
//
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
//import com.bloomtech.entities.URLPair;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class URLRepository {
//
//    @Autowired
//    private DynamoDBMapper mapper;
//
//    // Create
//    public URLPair save(URLPair urlPair) {
//        mapper.save(urlPair);
//        return urlPair;
//    }
//
//    // Read
//    public URLPair findByShortID(String shortId) {
//        return mapper.load(URLPair.class, shortId);
//    }
//
//    public List<URLPair> findAll() {
//        return mapper.scan(URLPair.class, new DynamoDBScanExpression());
//    }
//
//}

