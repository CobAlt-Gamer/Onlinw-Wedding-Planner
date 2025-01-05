package com.wedding.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/logs")
public class LogsController {

	@Autowired
	private CacheManager cacheManager;

	@GetMapping
	public ModelAndView logs() {
		return new ModelAndView("logs");
	}

	@GetMapping("/reset-cache")
	public ResponseEntity<Boolean> resetCache() {
		cacheManager.getCacheNames().parallelStream().forEach(naame -> cacheManager.getCache(naame).clear());
		return ResponseEntity.ok(true);
	}

}
