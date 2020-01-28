package com.springmongo.springmongo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ServiceInterceptorAppConfig implements WebMvcConfigurer {
    final
    ServiceInterceptor serviceInterceptor;

    public ServiceInterceptorAppConfig(ServiceInterceptor serviceInterceptor) {
        this.serviceInterceptor = serviceInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(serviceInterceptor);
    }

}
