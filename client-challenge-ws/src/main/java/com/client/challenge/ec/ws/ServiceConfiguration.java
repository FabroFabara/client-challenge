package com.client.challenge.ec.ws;

import com.client.challenge.ec.bs.utils.GenericConverterUtils;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.client.challenge.ec.ws", "com.client.challenge.ec.bs", "com.client.challenge.ec.ds"})
@EntityScan(basePackages = {"com.client.challenge.ec.ds.entity"})
@EnableJpaRepositories(basePackages = {"com.client.challenge.ec.bs.repository"})
public class ServiceConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public GenericConverterUtils genericConverterUtils(ModelMapper modelMapper) {
        return new GenericConverterUtils(modelMapper);
    }
}
