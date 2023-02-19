package com.chuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MutablePropertySources;

@SpringBootApplication
public class PlaySpringBootApplication {

    public static ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(PlaySpringBootApplication.class, args);
        MutablePropertySources propertySources = applicationContext.getEnvironment().getPropertySources();
        // applicationXxx的一系列配置文件都会被SpringBoot读取到Spring容器，只不过其中配置是否生效取决于优先级关系等设定
        // 查看其中的若干个PropertySource的顺序，就可以知道application配置文件的优先级关系了
        System.out.println(propertySources);
    }

}
