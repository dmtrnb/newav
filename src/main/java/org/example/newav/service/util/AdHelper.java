package org.example.newav.service.util;

import org.example.newav.repository.dto.AdDto;
import org.example.newav.repository.entity.Ad;
import org.example.newav.repository.mapper.AdMapper;

import java.util.List;

public class AdHelper {

    public static AdDto getDtoFromAd(Ad ad, List<String> fields) {
        if (ad == null)
            return null;

        AdDto adDto = AdMapper.fromEntityToDto(ad);

        if (fields != null) {
            fields.forEach(String::toLowerCase);
            if (!fields.contains("description")) {
                adDto.setDescription(null);
            }
            if (!fields.contains("all_photos")) {
                adDto.setOtherPhotos(null);
            }
        }
        return adDto;
    }
}
