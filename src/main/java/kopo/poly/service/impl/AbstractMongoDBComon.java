package kopo.poly.service.impl;

import com.mongodb.client.model.Indexes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

@Slf4j
public class AbstractMongoDBComon {

    @Autowired
    protected MongoTemplate mongodb;


    protected boolean createColletion(String colNm){

        boolean res;

        if (mongodb.collectionExists(colNm)){
            res = false;

        }else{
            mongodb.createCollection(colNm);

            res = true;
        }

        return res;
    }
    protected boolean createCollection(String colNm, String index){

        String[] indexArr = {index};

        return createCollection(colNm, indexArr);
    }
    protected boolean createCollection(String colNm, String[] index){

        log.info(this.getClass().getName()+".createCollection Start!");

        boolean res = false;

        if (!mongodb.collectionExists(colNm)){

            if (index.length > 0){

                mongodb.createCollection(colNm).createIndex(Indexes.ascending(index));

            }else{

                mongodb.createCollection(colNm);
            }
            res = true;

        }
        log.info(this.getClass().getName()+".createCollection End");

        return res;

    }
}
