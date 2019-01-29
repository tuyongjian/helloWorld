package com.tu.service.action;

import com.tu.common.util.MD5Util;
import com.tu.curd.model.ShiroUser;
import com.tu.curd.service.IShiroUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by len on 2019/1/24.
 */
@Controller
@RequestMapping(value = "shiro")
public class ShiroAction {
    private Logger logger = LoggerFactory.getLogger(ShiroAction.class);
    @Autowired
    private IShiroUserService shiroUserService;


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "/shiro/login";
    }

    @RequestMapping(value = "/success",method = RequestMethod.GET)
    public String success(){
        return "/shiro/success";
    }
    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String error(){
        return "/shiro/error";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "/shiro/test";
    }





    //登录认证
     @RequestMapping(value = "/shiro-login",method = RequestMethod.GET)
     public String login1(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                          HttpServletRequest request){
         Subject subject = SecurityUtils.getSubject();
         UsernamePasswordToken token = new UsernamePasswordToken(username,password);
         try {
             //执行认证操作.
             subject.login(token);
         }catch (AuthenticationException ae) {
             System.out.println("登陆失败: " + ae.getMessage());
             return "/shiro/login";
         }
         SavedRequest savedRequest = WebUtils.getSavedRequest(request);
         logger.info("-------------"+request.getScheme());
         logger.info("-------------"+request.getServerName());
         logger.info("-------------"+request.getServerPort());
         logger.info("-------------"+savedRequest.getRequestUrl());
         logger.info("-------------"+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+savedRequest.getRequestUrl());
         if(savedRequest!=null){

             return "redirect:"+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+savedRequest.getRequestUrl();
         }else{
             return "/shiro/success";
         }
     }
}
