package dev.correa.springbootsuperheroes.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Bruno Miguel Correa
 * Email: devsistemascorrea@gmail.com
 * Data: 18/06/2025
 **/

@Configuration
public class ModelMapperConfig {
	@Bean
	public ModelMapper modelMapper () {
		return new ModelMapper();
	}
}
