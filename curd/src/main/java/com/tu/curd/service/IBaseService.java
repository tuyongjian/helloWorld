package com.tu.curd.service;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by len on 2019/1/23.
 */
public interface IBaseService <M extends Serializable>{

    M queryModel(int id);

    M queryModel(M m);

    int addModel(M m);

    int updateModel(M m);

    int deleteModel(M m);

    int deleteModel(Map<String,Object> map);
}
