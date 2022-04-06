package com.company.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {

    @Bean
    public ModelConfig getModelConfig(){
        return new ModelConfig();
    }

}
