package com.chuan.ioc.ant.lookup;

import com.chuan.ioc.IUserDAO;
import com.chuan.ioc.IUserService;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

/**
 * @author xucy-e
 */
@Service
public class UserServiceInLookupPackage implements IUserService {

    @Lookup
    @Override
    public IUserDAO getUserDAO() {
        return null;
    }

    @Override
    public String introduce(String userName) {
        return String.format("I am %s.", userName);
    }
}
