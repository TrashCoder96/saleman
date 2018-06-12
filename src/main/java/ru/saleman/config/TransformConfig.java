package ru.saleman.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */
@Configuration
public class TransformConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
