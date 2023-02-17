package com.chuan.ioc.xml.bean;

import com.chuan.ioc.IUserDAO;

/**
 * @author xucy-e
 */
public class XMLUserDAO implements IUserDAO {
    @Override
    public String find() {
        return "123456";
    }
}
