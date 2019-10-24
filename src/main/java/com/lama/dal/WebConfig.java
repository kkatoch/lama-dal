package com.lama.dal;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000","https://www.beta.lamaart.co.uk",
                        "https://www.lamaart.co.uk","https://www.beta.lamaart.uk",
                        "https://www.lamaart.uk","https://www.beta.lamaart.co",
                        "https://www.lamaart.co","https://beta.lamaart.co.uk",
                        "https://lamaart.co.uk","https://beta.lamaart.uk",
                        "https://lamaart.uk","https://beta.lamaart.co",
                        "https://lamaart.co")
                .allowedMethods("GET");
    }
}