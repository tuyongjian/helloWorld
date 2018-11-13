package com.tu.webservice.service;

import javax.jws.WebService;

/**
 * Created by tuyongjian on 2018/11/13.
 */
@WebService
public class WeatherInterfaceImpl implements WeatherInterface {
    @Override
    public String queryWeather(String cityName) {
        String weather = "阴天";
        return weather;

    }
}
