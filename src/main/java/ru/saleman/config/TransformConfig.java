package ru.saleman.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.saleman.manager.converter.AccountDtoVoConverter;

/**
 * Created by Ivan Timofeev on 10.06.2018.
 */
@Configuration
public class TransformConfig {

    @Autowired
    private AccountDtoVoConverter accountDtoVoConverter;

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(accountDtoVoConverter);
        return modelMapper;
    }

}
