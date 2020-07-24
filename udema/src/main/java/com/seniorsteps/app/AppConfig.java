package com.seniorsteps.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.seniorsteps.app")
@PropertySource("classpath:application.properties")
public class AppConfig {

	
}
