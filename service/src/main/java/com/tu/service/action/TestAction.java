package com.tu.service.action;

import com.tu.common.dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tuyongjian on 2019/1/6.
 */
@Controller
@RequestMapping(value = "test")
public class TestAction {

    private Logger logger = LoggerFactory.getLogger(TestAction.class);

    @ResponseBody
    @RequestMapping(value = "test",method = RequestMethod.POST)
    public Result test(){
        Result result = new Result(true,"TEST");
        logger.info("------------[{}]",result.toString());
        return result;
    }
}
