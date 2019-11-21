package com.netcracker.hackathon.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration("hackathon-conf")
public class BeanConfig {
    private String DB_NAME = "car_assistant";
    private String USER = "sysadm";
    private String PASSWORD = "netcracker";
    private String URL = "mongodb://" + USER + ":" + PASSWORD +
            "@clusterhack-shard-00-00-x8yri.mongodb.net:27017," +
            "clusterhack-shard-00-01-x8yri.mongodb.net:27017," +
            "clusterhack-shard-00-02-x8yri.mongodb.net:27017" +
            "/test?" +
            "ssl=true&" +
            "replicaSet=ClusterHack-shard-0&" +
            "authSource=admin&" +
            "retryWrites=true&" +
            "w=majority&";

    @Bean
    public MongoDbFactory mongoDbFactory() {
        MongoClientURI uri = new MongoClientURI(URL);
        MongoClient mongoClient = new MongoClient(uri);
        return new SimpleMongoDbFactory(mongoClient, DB_NAME);
    }

    @Bean
    public MappingMongoConverter mongoConverter(){
        MongoMappingContext mappingContext = new MongoMappingContext();
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
        MappingMongoConverter mongoConverter = new MappingMongoConverter(dbRefResolver, mappingContext);
        mongoConverter.setMapKeyDotReplacement("\\:");
        return mongoConverter;
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoDbFactory(), mongoConverter());
    }
}
