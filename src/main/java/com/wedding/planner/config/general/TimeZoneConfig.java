package com.wedding.planner.config.general;

import java.util.TimeZone;

import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class TimeZoneConfig {

	 @PostConstruct
	    public void init() {
	        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
	    }

}