package com.tu.service.action;

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

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

/**
 * Created by tuyongjian on 2019/1/6.
 * 用户Action
 */
@Controller
@RequestMapping(value = "user")
public class UserAction {

    private Logger logger = LoggerFactory.getLogger(UserAction.class);

    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "test",method = RequestMethod.POST)
    public Result test(){
        Result result = new Result(true,"TEST");
        logger.info("------------[{}]",result.toString());
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "queryUser",method = RequestMethod.POST)
    public User queryUser(ModelMap model,
                      @RequestParam(value = "id") int id,
                          HttpServletResponse response){
        User user  = this.userService.queryUser(id);
        //int i = 1/0;
        logger.info("queryUser is [{}]",user.toString());
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public Result addUser(ModelMap model){
        User user  = new User();
        user.setUserName("屠永建");
        user.setPassword("123");
        user.setMobile("18221483894");
        user.setAddress("安徽省阜阳市颍上县");
        user.setEmail("123123@qq.com");
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        user.setRemark("测试");
        userService.addUser(user);
        return new Result(true,"插入成功");
    }
}
