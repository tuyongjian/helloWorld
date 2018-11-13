package com.tu.webservice.service;

import javax.xml.ws.Endpoint;

/**
 * Created by tuyongjian on 2018/11/13.
 */
public class WeatherService {

    public static void main(String[] args) {
        //发布服务
        Endpoint.publish("http://localhost:1234/weather",new WeatherInterfaceImpl());
        System.out.println("publish success!");
    }
}
