package com.tu.curd.util;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by len on 2019/1/15.
 */
public class DataSourceAspect {

    private Logger logger  = LoggerFactory.getLogger(DataSourceAspect.class);
    /**
     * 在调用Dao方法获取DataSource对象之前，在切面中指定当期线程数据源
     */

    public void before(JoinPoint point){

        Object target = point.getTarget();
        String method = point.getSignature().getName();
        // 获取目标类的接口， 所以@DataSource需要写在接口上
        Class<?>[] classz = target.getClass().getInterfaces();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {

            Method m = classz[0].getMethod(method,parameterTypes);
            if(m != null && m.isAnnotationPresent(DataSource.class)){
                DataSource data = m.getAnnotation(DataSource.class);
                logger.info("用户选择的数据库类型是："+data.value());
                // 数据源放到当前线程中
                HandleDataSource.putDataSource(data.value());
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
