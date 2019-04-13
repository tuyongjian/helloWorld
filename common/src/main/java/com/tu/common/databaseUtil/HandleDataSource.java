package com.tu.common.databaseUtil;

/**
 * Created by len on 2019/1/15.
 */
public class HandleDataSource {

    public static final ThreadLocal<String> threadLocal= new ThreadLocal<String>();

    public static void putDataSource(String dataSource){
        threadLocal.set(dataSource);
    }

    public static String getDataSource(){
        return threadLocal.get();
    }

}
