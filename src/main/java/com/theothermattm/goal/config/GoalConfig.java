package com.theothermattm.goal.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configurations for the application.
 * 
 * @author mattm
 * 
 */
@Configuration
@ComponentScan(basePackages = { "com.theothermattm.goal.controllers",
		"com.theothermattm.goal.service" })
public class GoalConfig {

}
