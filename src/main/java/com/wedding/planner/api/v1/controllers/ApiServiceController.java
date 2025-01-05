package com.wedding.planner.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wedding.planner.api.v1.dto.ResponseDTO;
import com.wedding.planner.api.v1.dto.ServiceDTO;
import com.wedding.planner.api.v1.service.ApiServiceService;
import com.wedding.planner.entity.ServiceCategories;

@RestController
@RequestMapping("/api/v1/service")
public class ApiServiceController {

    @Autowired
    private ApiServiceService serviceService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<ServiceDTO>>> services() {
        return serviceService.services();
    }

    @GetMapping("{service}")
    public ResponseEntity<ServiceDTO> service(@PathVariable("service") Long service){
    	return serviceService.service(service);
    }

    @GetMapping("/page/{page}/size/{size}")
    public ResponseEntity<ResponseDTO<List<ServiceDTO>>> services(@PathVariable("page") Integer page,
            @PathVariable("size") Integer size) {
        return serviceService.services(PageRequest.of(page, size));
    }

    @GetMapping("category")
    public ResponseEntity<ResponseDTO<List<ServiceDTO>>> services(@RequestParam("category") ServiceCategories category) {
        return serviceService.services(category);
    }

    @GetMapping("category/page/{page}/size/{size}")
    public ResponseEntity<ResponseDTO<List<ServiceDTO>>> services(@RequestParam("category") ServiceCategories category,
            @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return serviceService.services(category, PageRequest.of(page, size));
    }

}
