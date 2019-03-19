package com.tu.service.action;

import com.tu.service.service.IMongoDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by len on 2019/3/19.
 */

@Controller
@RequestMapping(value = "mongo")
public class MongoAction {

    private Logger logger = LoggerFactory.getLogger(MongoAction.class);

    @Autowired
    private IMongoDbService mongoDbService;


    @ResponseBody
    @RequestMapping(value = "test",method = RequestMethod.POST)
    public Object test(){
        this.mongoDbService.insert();
        return true;
    }


}
