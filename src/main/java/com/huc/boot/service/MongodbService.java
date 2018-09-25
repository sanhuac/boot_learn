package com.huc.boot.service;


import com.huc.boot.util.MongodbDriverUtil;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Sorts;
import org.springframework.stereotype.Service;
import org.bson.Document;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/12 14:26
 * @Description:
 */
@Service
public class MongodbService {

    Document d = null;
    String grabInfo = "";
    public String findYoudunCarrierByuserId(Integer userId){
        try {
            //连接mongdb数据库中，后面是指定的表名
            MongodbDriverUtil.mongodbDriver("moxie_taobao_alipaywealth");
            //根据用户id查询查询数据
            //	FindIterable<Document> findIterable = MongodbDriverUtil.collection.find(new Document("user_id",userId));  //new Document("task_id", "2fadsa2-213dadsaf-233").append("create_time", "12321315")).sort(Sorts.ascending("create_time")
            FindIterable<Document> findIterable = MongodbDriverUtil.collection.find(new Document("user_id", userId)).sort(Sorts.descending("create_time")).limit(1);
            //new Document("task_id", "2fadsa2-213dadsaf-233").append("create_time", "12321315")).sort(Sorts.ascending("create_time")
            //查询出来的数据进行迭代
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                d = mongoCursor.next();
                grabInfo=(String)d.get("grab_info");
            }
            System.out.println("Connect to database successfully");
        } catch (Exception e) {
            System.out.println("连接失败");
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }finally{
            MongodbDriverUtil.mongoClient.close();
        }
        return grabInfo;
    }

}

