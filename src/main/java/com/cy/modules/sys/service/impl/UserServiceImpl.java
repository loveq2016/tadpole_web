package com.cy.modules.sys.service.impl;

import com.cy.modules.sys.dao.UserMapper;
import com.cy.modules.sys.entity.User;
import com.cy.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KAM on 2015/12/4.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userdao;
    @Override
    public User getEntityById(String id) {
        return userdao.selectByPrimaryKey(id);
    }
}
