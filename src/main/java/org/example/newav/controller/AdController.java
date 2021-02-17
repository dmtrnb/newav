package org.example.newav.controller;

import io.swagger.annotations.*;
import org.example.newav.repository.dto.AdInDto;
import org.example.newav.repository.dto.AdOutDto;
import org.example.newav.repository.entity.BaseResponse;
import org.example.newav.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Ads")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal server error")
})
@RestController
public class AdController {

    private final AdService adService;

    @Autowired
    public AdController(AdService service) {
        this.adService = service;
    }

    @ApiOperation(value = "Получить объявление по его идентификатору",
            notes = "Идентификатор передаётся как параметр",
            response = AdOutDto.class)
    @GetMapping("/findById")
    public ResponseEntity<AdOutDto> findByIdParam(@ApiParam(value = "идентификатор объявления", required = true,
                                                                    defaultValue = "2") @RequestParam Long id,
                                             @RequestParam(required = false) List<String> fields) {
        return new BaseResponse<>(adService.returnDto(id, fields)).getResponseEntity();
    }

    @ApiOperation(value = "Получить объявление по его идентификатору",
            notes = "Идентификатор передаётся как переменная пути",
            response = AdOutDto.class)
    @GetMapping("/findById/{id}")
    public ResponseEntity<AdOutDto> findById(@ApiParam(value = "идентификатор объявления", required = true,
                                                                    defaultValue = "2") @PathVariable Long id,
                                             @RequestParam(required = false) List<String> fields) {
        return new BaseResponse<>(adService.returnDto(id, fields)).getResponseEntity();
    }

    @ApiOperation(value = "Добавить новое объявление",
            notes = "Перед добавлением проходит валидация", response = Long.class)
    @PostMapping("/add")
    public ResponseEntity<Long> add(@ApiParam(value = "Заготовка для сущности") @RequestBody AdInDto adInDto) {
        return new BaseResponse<>(adService.add(adInDto)).getResponseEntity();
    }

    @ApiOperation(value = "Получить отсортированный постраничный список всех объявлений",
            notes = "По умолчанию выдаётся первая страница с 10 элементами, отсортированная от младшего к старшему",
            response = AdOutDto.class)
    @GetMapping("/findAll")
    public ResponseEntity<Page<AdOutDto>> findAll(
            @ApiParam(value = "Страница", defaultValue = "0") @RequestParam(defaultValue = "0") int page,
            @ApiParam(value = "Элементов на страницу", defaultValue = "10") @RequestParam(defaultValue = "10") int size,
            @ApiParam(value = "По убыванию или возрастанию", defaultValue = "DESC") @RequestParam(defaultValue = "DESC") String sort,
            @ApiParam(value = "Сортировка по столбцу", defaultValue = "creation_date") @RequestParam(defaultValue = "creation_date") String column) {
        return new BaseResponse<>(adService.findAll(page, size, sort, column)).getResponseEntity();
    }
}
