package com.chuan.ioc.ant.beanMethod.bean.y;

import com.chuan.ioc.ant.beanMethod.bean.BeanO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xucy-e
 */
@Getter
@NoArgsConstructor
public class BeanY {
    private String name;

    public BeanY(String name) {
        this.name = name;
    }

    @Autowired
    private BeanO beanO;
}
