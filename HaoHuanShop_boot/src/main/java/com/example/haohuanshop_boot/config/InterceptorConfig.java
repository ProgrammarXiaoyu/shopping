package com.example.haohuanshop_boot.config;

import com.example.haohuanshop_boot.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] addPathPatterns = {
                "/user/**", "/purchase"
        };
        String[] excludePathPatterns = {
                "/user/logoff", "/user/login"
        };

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }

    /**
     * 允许跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*").allowedHeaders("*").allowCredentials(true).allowedMethods("*").maxAge(3600);
    }
}
