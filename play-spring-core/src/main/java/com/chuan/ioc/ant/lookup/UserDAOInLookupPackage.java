package com.chuan.ioc.ant.lookup;

import com.chuan.ioc.IUserDAO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author xucy-e
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Repository
public class UserDAOInLookupPackage implements IUserDAO {
    @Override
    public String find() {
        return "123456";
    }
}
