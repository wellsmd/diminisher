package com.bloomtech.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@Data
@DynamoDBTable(tableName = "urls")
public class URL {

    @DynamoDBHashKey
    private String short_id;

    @DynamoDBAttribute
    private String original_url;

}
