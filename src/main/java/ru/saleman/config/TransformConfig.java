package ru.saleman.config;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */
@Configuration
public class TransformConfig {

    @Autowired
    private List<AbstractConverter> converters;

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        converters.stream().forEach(converter -> {
            modelMapper.addConverter(converter);
        });
        return modelMapper;
    }

}
