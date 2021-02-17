package org.example.newav.service;

import org.example.newav.repository.AdRepository;
import org.example.newav.repository.dto.AdDto;
import org.example.newav.repository.entity.Ad;
import org.example.newav.repository.mapper.AdMapper;
import org.example.newav.service.util.AdHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {

    private final AdRepository adRepository;

    @Autowired
    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public AdDto returnDto(Ad ad, List<String> fields) {
        return AdHelper.getDtoFromAd(ad, fields);
    }
}
