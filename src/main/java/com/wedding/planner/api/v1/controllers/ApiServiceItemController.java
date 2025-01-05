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
import com.wedding.planner.api.v1.dto.ServiceItemDTO;
import com.wedding.planner.api.v1.service.ApiServiceItemService;
import com.wedding.planner.entity.Services;

@RestController
@RequestMapping("/api/v1/service-item")
public class ApiServiceItemController {

    @Autowired
    private ApiServiceItemService itemService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<ServiceItemDTO>>> serviceItems() {
        return itemService.serviceItems();
    }

    @GetMapping("{item}")
    public ResponseEntity<ServiceItemDTO> serviceItem(@PathVariable("item") Long item){
    	return itemService.serviceItem(item);
    }

    @GetMapping("page/{page}/size/{size}")
    public ResponseEntity<ResponseDTO<List<ServiceItemDTO>>> serviceItems(@PathVariable("page") Integer page,
            @PathVariable("size") Integer size) {
        return itemService.serviceItems(PageRequest.of(page, size));
    }

    @GetMapping("service")
    public ResponseEntity<ResponseDTO<List<ServiceItemDTO>>> serviceItems(@RequestParam("service") Services service) {
        return itemService.serviceItems(service);
    }

    @GetMapping("service/page/{page}/size/{size}")
    public ResponseEntity<ResponseDTO<List<ServiceItemDTO>>> serviceItems(@RequestParam("service") Services service,
            @PathVariable Integer page, @PathVariable("size") Integer size) {
        return itemService.serviceItems(service, PageRequest.of(page, size));
    }

}
