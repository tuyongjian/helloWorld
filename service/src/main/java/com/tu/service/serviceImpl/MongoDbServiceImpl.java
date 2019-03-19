package com.tu.service.serviceImpl;

import com.mongodb.client.MongoCollection;
import com.tu.service.service.IMongoDbService;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by len on 2019/3/19.
 */
@Service
public class MongoDbServiceImpl implements IMongoDbService {

    private Logger logger = LoggerFactory.getLogger(MongoDbServiceImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert() {
        MongoCollection<Document> collection = mongoTemplate.getCollection("runoob");
        Document document = new Document("title", "MongoDB").
        append("description", "database").
        append("likes", 100).
        append("by", "Fly");
        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        collection.insertMany(documents);
        logger.info("MongoDB插入成功-----------------");
    }

}
