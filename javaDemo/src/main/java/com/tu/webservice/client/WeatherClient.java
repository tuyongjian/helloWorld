package com.tu.webservice.client;

/**
 * Created by tuyongjian on 2018/11/13.
 */
public class WeatherClient {

    public static void main(String[] args) {

        WeatherInterfaceImplService weatherInterfaceImplService = new WeatherInterfaceImplService();
        WeatherInterfaceImpl weatherInterface = weatherInterfaceImplService.getWeatherInterfaceImplPort();
        String wather  =  weatherInterface.queryWeather("111");
        System.out.println(wather);
    }
}
