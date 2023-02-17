package com.chuan.ioc.ant.autowired;

import com.chuan.ioc.IUserDAO;
import com.chuan.ioc.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author xucy-e
 */
@Lazy
@Service
public class UserServiceWithPrivateConstructor implements IUserService {

    @Autowired
    private UserServiceWithPrivateConstructor() {
        System.out.println("---------------come in private constructor---------------");
    }

    @Override
    public String introduce(String userName) {
        return null;
    }

    @Override
    public IUserDAO getUserDAO() {
        return null;
    }
}
