package org.example.newav.service;

import org.example.newav.repository.AdRepository;
import org.example.newav.repository.dto.AdInDto;
import org.example.newav.repository.dto.AdOutDto;
import org.example.newav.repository.entity.Ad;
import org.example.newav.service.util.AdHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {

    private final AdRepository adRepository;

    @Autowired
    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public AdOutDto returnDto(Long id, List<String> fields) {
        return AdHelper.getDtoFromAd(adRepository.findById(id).orElse(null), fields);
    }

    public Long add(AdInDto adInDto) {
        Ad ad = AdHelper.getAdFromDto(adInDto);
        return ad != null ? adRepository.save(ad).getId() : null;
    }

    public Page<AdOutDto> findAll(int page, int size, String sort, String column) {
        Pageable pageable = PageRequest.of(page, size, AdHelper.getSort(sort, column));
        Page<Ad> adPage = adRepository.findAll(pageable);
        return adPage.map(AdHelper::getDtoForPages);
    }
}
