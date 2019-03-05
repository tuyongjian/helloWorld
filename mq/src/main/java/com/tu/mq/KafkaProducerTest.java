package com.tu.mq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by tuyongjian on 2019/3/5.
 */
@Controller
public class KafkaProducerTest {

    @RequestMapping(value = "test")
    public String test(){
        KafkaProducerServer kafkaProducerServer = new KafkaProducerServer();

        String topic = "orderTopic";
        String value = "test";
        String ifPartition = "0";
        Integer partitionNum = 3;
        String role = "test";//用来生成key
        Map<String,Object> res = kafkaProducerServer.sendMesForTemplate
                (topic, value, ifPartition, partitionNum, role);

        System.out.println("测试结果如下：===============");
        String message = (String)res.get("message");
        String code = (String)res.get("code");

        System.out.println("code:"+code);
        System.out.println("message:"+message);
        return null;
    }
}
