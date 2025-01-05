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
import com.wedding.planner.api.v1.dto.VariationOptionDTO;
import com.wedding.planner.api.v1.service.ApiVariationOptionService;
import com.wedding.planner.entity.Variation;

@RestController
@RequestMapping("/api/v1/variation-option")
public class ApiVariationOptions {

    @Autowired
    private ApiVariationOptionService variationOptionService;

    @GetMapping
    ResponseEntity<ResponseDTO<List<VariationOptionDTO>>> variationOptions() {
        return variationOptionService.variationOptions();
    }

    @GetMapping("page/{page}/size/{size}")
    ResponseEntity<ResponseDTO<List<VariationOptionDTO>>> variationOptions(@PathVariable("page") Integer page,
            @PathVariable("size") Integer size) {
        return variationOptionService.variationOptions(PageRequest.of(page, size));
    }

    @GetMapping("variation")
    ResponseEntity<ResponseDTO<List<VariationOptionDTO>>> variationOptions(@RequestParam("variation") Variation variation) {
        return variationOptionService.variationOptions(variation);
    }

    @GetMapping("variation/page/{page}/size/{size}")
    ResponseEntity<ResponseDTO<List<VariationOptionDTO>>> variationOptions(@RequestParam("variation") Variation variation,
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size) {
        return variationOptionService.variationOptions(variation, PageRequest.of(page, size));
    }
}
