package com.chuan.ioc.xml.replacer;

import com.chuan.ioc.IUserService;
import com.chuan.util.MyPrinter;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author xucy-e
 */
public class ReplacementSetUserName implements MethodReplacer {

    @Override
    public Object reimplement(Object o, Method method, Object[] objects) {
        MyPrinter.println("--------------reimplement invoked--------------");
        IUserService userService = (IUserService) o;
        String userName = (String) objects[0];
        return "I am LiSi.";
    }
}
