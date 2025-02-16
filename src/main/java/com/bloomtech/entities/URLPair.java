//package com.bloomtech.entities;
//
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
//import lombok.Data;
//
//@Data
//@DynamoDBTable(tableName = "urls")
//public class URLPair {
//
//    private String shortId;
//    private String originalUrl;
//
//    public URLPair() {
//    }
//
//    public URLPair(String shortId, String originalUrl) {
//        this.shortId = shortId;
//        this.originalUrl = originalUrl;
//    }
//
//    @DynamoDBHashKey
//    public String getShortId() {
//        return shortId;
//    }
//
//    public void setShortId(String shortId) {
//        this.shortId = shortId;
//    }
//
//    @DynamoDBAttribute
//    public String getOriginalUrl() {
//        return originalUrl;
//    }
//
//    public void setOriginalUrl(String originalUrl) {
//        this.originalUrl = originalUrl;
//    }
//
//}
