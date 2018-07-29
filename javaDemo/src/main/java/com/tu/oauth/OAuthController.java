package com.tu.oauth;

import com.tu.jedis.JedisClientPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tuyongjian on 2018/7/29.
 */

@Controller
@RequestMapping(value = "oAuth")
public class OAuthController {

    private Logger logger = LoggerFactory.getLogger(OAuthController.class);


    @Autowired
    private JedisClientPool jedisClientPool;

    @RequestMapping(value = "test",method = RequestMethod.POST)
    @ResponseBody
    public OAuthResponse test(ModelMap model){
        OAuthResponse oAuthResponse = new OAuthResponse();
        oAuthResponse.setAcces_token("111");
        logger.info("---------------"+oAuthResponse.getAcces_token());
        jedisClientPool.set("name","tuyongjian");

        return oAuthResponse;
    }
}
