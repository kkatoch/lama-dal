package com.lama.dal;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000","https://beta.lamaart.co.uk",
                        "https://lamaart.co.uk","https://beta.lamaart.uk",
                        "https://lamaart.uk")
                .allowedMethods("GET");
    }
}