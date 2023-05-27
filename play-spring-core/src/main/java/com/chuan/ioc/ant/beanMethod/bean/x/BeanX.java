package com.chuan.ioc.ant.beanMethod.bean.x;

import com.chuan.ioc.ant.beanMethod.bean.BeanO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xucy-e
 */
@Getter
@NoArgsConstructor
public class BeanX {
    private String name;

    public BeanX(String name) {
        this.name = name;
    }

    @Autowired
    private BeanO beanO;
}
