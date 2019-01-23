package com.tu.curd.serviceImpl;

import com.tu.curd.dao.ShiroPermissionDao;
import com.tu.curd.model.ShiroPermission;
import com.tu.curd.service.IShiroPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by len on 2019/1/23.
 */
@Service
public class ShiroPermissionServiceImpl implements IShiroPermissionService {

    @Autowired
    private ShiroPermissionDao shiroPermissionDao;


    public ShiroPermission queryModel(int id) {
        return shiroPermissionDao.selectById(id);
    }

    public ShiroPermission queryModel(ShiroPermission ShiroPermission) {
        return shiroPermissionDao.selectOne(ShiroPermission);
    }

    public int addModel(ShiroPermission ShiroPermission) {
        return shiroPermissionDao.insert(ShiroPermission);
    }

    public int updateModel(ShiroPermission ShiroPermission) {
        return shiroPermissionDao.update(ShiroPermission);
    }

    public int deleteModel(ShiroPermission ShiroPermission) {
        return shiroPermissionDao.delete(ShiroPermission);
    }

    public int deleteModel(Map<String, Object> map) {
        return shiroPermissionDao.delete(map);
    }
}
