package org.example.newav.controller;

import org.example.newav.repository.dto.AdDto;
import org.example.newav.repository.entity.Ad;
import org.example.newav.repository.entity.BaseResponse;
import org.example.newav.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdController {

    private final AdService adService;

    @Autowired
    public AdController(AdService service) {
        this.adService = service;
    }

    @GetMapping("/findById")
    public ResponseEntity<AdDto> findById(@RequestParam long id,
                                          @RequestParam(required = false) List<String> fields) {
        return new BaseResponse<>(adService.findById(id, fields)).getResponseEntity();
    }

}
