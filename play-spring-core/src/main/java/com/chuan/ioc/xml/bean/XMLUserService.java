package com.chuan.ioc.xml.bean;

import com.chuan.ioc.IUserDAO;
import com.chuan.ioc.IUserService;
import lombok.Getter;

/**
 * @author xucy-e
 */
public class XMLUserService implements IUserService {

    @Getter
    private IUserDAO userDAO;

    public void setUserDAO(IUserDAO userDAO) {
        System.out.println("--------------setUserDAO invoked--------------");
        this.userDAO = userDAO;
    }

    @Override
    public String introduce(String userName) {
        return "I am " + userName + ".";
    }
}
