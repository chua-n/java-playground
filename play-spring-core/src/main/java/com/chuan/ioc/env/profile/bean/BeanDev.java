package com.chuan.ioc.env.profile.bean;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author xucy-e
 */
@Profile("dev")
@Component
public class BeanDev {
}
