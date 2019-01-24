package com.tu.service.serviceImpl;

import com.tu.common.util.MD5Util;
import com.tu.curd.model.ShiroUser;
import com.tu.curd.service.IShiroUserService;
import com.tu.service.service.IShiroAccountService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by len on 2019/1/24.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IShiroAccountService shiroAccountService;

    @Autowired
    private IShiroUserService shiroUserService;

    /***
     * 获取授权信息
     */

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //根据系统规则设置授权信息

        String username = (String) principalCollection.fromRealm(getName()).iterator().next();
        if(username!=null){
            List<String> pers = shiroAccountService.getPermissionByUserId(Integer.parseInt(username));

            if(pers!=null && !pers.isEmpty()){
                SimpleAuthorizationInfo simpleAuthorizationInfo= new SimpleAuthorizationInfo();
                for (String each:pers) {
                    //将权限资源添加到用户信息中
                    simpleAuthorizationInfo.addStringPermission(each);
                }
                return simpleAuthorizationInfo;
            }
          
        }


        return null;
    }

    /***
     * 获取认证信息
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());

        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
            ShiroUser shiroUser = new ShiroUser();
            shiroUser.setUserName(username);
            shiroUser.setPassword(password);
            ShiroUser user = shiroUserService.queryModel(shiroUser);
           if(user!=null){
               return new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),getName());
           }
        }

        return null;
    }
}
