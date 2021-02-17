package org.example.newav.controller;

import org.example.newav.repository.dto.AdInDto;
import org.example.newav.repository.dto.AdOutDto;
import org.example.newav.repository.entity.Ad;
import org.example.newav.repository.entity.BaseResponse;
import org.example.newav.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdController {

    private final AdService adService;

    @Autowired
    public AdController(AdService service) {
        this.adService = service;
    }

    @GetMapping({"/findById", "/findById/{ad}"})
    public ResponseEntity<AdOutDto> findById(@RequestParam(required = false) Ad id,
                                             @PathVariable(required = false) Ad ad,
                                             @RequestParam(required = false) List<String> fields) {
        return new BaseResponse<>(adService.returnDto(id == null ? ad : id, fields)).getResponseEntity();
    }

    @PostMapping("/add")
    public ResponseEntity<Long> add(@RequestBody AdInDto adInDto) {
        return new BaseResponse<>(adService.add(adInDto)).getResponseEntity();
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<AdOutDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "DESC") String sort,
            @RequestParam(defaultValue = "creation_date") String column) {
        return new BaseResponse<>(adService.findAll(page, size, sort, column)).getResponseEntity();
    }
}
