package com.chuan.ioc;

/**
 * @author xucy-e
 */
public interface IUserService {

    String introduce(String userName);

    IUserDAO getUserDAO();
}
