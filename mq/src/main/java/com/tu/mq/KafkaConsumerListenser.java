package com.tu.mq;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * Created by len on 2019/3/4.
 */
public class KafkaConsumerListenser {

    /**
     * @param data
     */
    @KafkaListener(groupId="xxx" ,topics = "xxx")
    void listener(ConsumerRecord<String, String> data){
        System.out.println("消费者线程："+Thread.currentThread().getName()+"[ 消息 来自kafkatopic："+data.topic()+",分区："+data.partition()
                +" ，委托时间："+data.timestamp()+"]消息内容如下：");
        System.out.println(data.value());
    }
}
