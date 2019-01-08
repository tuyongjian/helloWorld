package com.tu.service.action;

import com.tu.common.controller.BaseController;
import com.tu.common.dto.Result;
import com.tu.curd.model.User;
import com.tu.curd.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tuyongjian on 2019/1/6.
 */
@Controller
@RequestMapping(value = "test")
public class TestAction extends BaseController {

    private Logger logger = LoggerFactory.getLogger(TestAction.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "error/405";
    }

    @ResponseBody
    @RequestMapping(value = "test",method = RequestMethod.POST)
    public Result test(){
        Result result = new Result(true,"TEST");
        logger.info("------------[{}]",result.toString());
        int i= 1/0;
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public User query(ModelMap model,
                      @RequestParam(value = "id") int id){
        User user  = this.userService.queryUser(id);
        return user;
    }
}
