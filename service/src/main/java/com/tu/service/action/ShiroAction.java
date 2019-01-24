package com.tu.service.action;

import com.tu.common.util.MD5Util;
import com.tu.curd.model.ShiroUser;
import com.tu.curd.service.IShiroUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by len on 2019/1/24.
 */
@Controller
@RequestMapping(value = "shiro")
public class ShiroAction {

    @Autowired
    private IShiroUserService shiroUserService;

     /*** 
      * 跳转到登录页面 
      *  
      * @return 
      */
     @RequestMapping(value = "toLogin",method = RequestMethod.GET)
     public String toLogin(){
         return "shiro/login";
     }

    @RequestMapping(value = "login")
    public ModelAndView  login(String username, String password){
        ModelAndView  mav = new ModelAndView();
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setUserName(username);
        shiroUser.setPassword(MD5Util.md5(password));
        ShiroUser  shiroUser1 = shiroUserService.queryModel(shiroUser);
        if(shiroUser1 ==null){
            mav.setViewName("shiro/login");
            mav.addObject("msg", "用户不存在");
            return mav;
        }
       if(!shiroUser1.getPassword().equals(MD5Util.md5(password))){
           mav.setViewName("shiro/login");
           mav.addObject("msg", "账号密码错误");
           return mav;
        }

        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
       //登录之后存放入shiro token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(shiroUser.getUserName(),shiroUser.getPassword());
        Subject subject  = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);
        mav.setViewName("/shiro/home");
        return mav;
    }

    @RequestMapping(value = "home")
    public String home(){
        return "/shiro/home";
    }

}
