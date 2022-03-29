package kopo.poly.service.impl;

import kopo.poly.dto.MongoDTO;
import kopo.poly.persistance.mongodb.IMongoMapper;
import kopo.poly.service.IMongoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service("MongoService")
public class MongoService implements IMongoService {

    @Resource(name = "MongoMapper")
    private IMongoMapper mongoMapper;

    @Override
    public void mongoTest() throws Exception{

        log.info(this.getClass().getName()+".mongoTest Start");

        String colNm = "MONGODB_TEST";

        MongoDTO pDTO = new MongoDTO();
        pDTO.setUser_nm("김지혁");
        pDTO.setAddr("수원");
        pDTO.setEmail("flap04@naver.com");

        mongoMapper.insertData(pDTO, colNm);

        log.info(this.getClass().getName()+".mongoTest end");
    }
}
