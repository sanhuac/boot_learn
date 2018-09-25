
package com.huc.boot.util;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/12 15:00
 * @Description:
 */
public class MongodbDriverUtil {

    public static MongoCollection<Document> collection=null;

    public static MongoClient mongoClient=null;

    public static final String mongodb_ip_1 = "dds-bp1665a85a2abfb41946-pub.mongodb.rds.aliyuncs.com";

    public static final String mongodb_port_1 = "3717";

    public static final String mongodb_nodes = "1";

    public static final String mongodb_ip_2 = "dds-bp1665a85a2abfb42888-pub.mongodb.rds.aliyuncs.com";

    public static final String mongodb_port_2 = "3717";

    public static final String mongodb_username = "root";

    public static final String mongodb_default_database = "admin";

    public static final String mongodb_pwd = "s3w6LNFmh8a19WAX";

    public static final String mongodb_replica_name = "mgset-6366973";

    public static final String mongodb_real_database = "lanmei";

    public static MongoCollection<Document> mongodbDriver(String tableName){
        System.out.println("连接mongodb");

        ServerAddress serverAddress = new ServerAddress(mongodb_ip_1,Integer.parseInt(mongodb_port_1));
        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
        addrs.add(serverAddress);
        int nods = Integer.parseInt(mongodb_nodes);
        if(nods==2){
            ServerAddress serverAddress1 = new ServerAddress(mongodb_ip_2,Integer.parseInt(mongodb_port_2));
            addrs.add(serverAddress1);
        }

        MongoCredential credential = MongoCredential.createScramSha1Credential(mongodb_username, mongodb_default_database, mongodb_pwd.toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);
        MongoClientOptions o = MongoClientOptions.builder()
                .requiredReplicaSetName(mongodb_replica_name).localThreshold(1).serverSelectionTimeout(1000).connectionsPerHost(1).connectTimeout(1000).build();
        mongoClient = new MongoClient(addrs,credentials,o);


        //连接数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase(mongodb_real_database);
        //创建表格
//        mongoDatabase.createCollection("mobile");

        collection = mongoDatabase.getCollection(tableName);
        return collection;
    }
}

