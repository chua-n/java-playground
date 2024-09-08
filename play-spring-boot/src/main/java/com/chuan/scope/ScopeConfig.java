package com.chuan.scope;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xucy-e
 */
@Configuration
public class ScopeConfig {

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(TenantScope tenantScope) {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope(TenantSpecific.SCOPE_NAME, tenantScope);
        return configurer;
    }
}
