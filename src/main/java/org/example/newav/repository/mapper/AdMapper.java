package org.example.newav.repository.mapper;

import org.example.newav.repository.dto.AdDto;
import org.example.newav.repository.entity.Ad;

import java.util.Date;

public class AdMapper {

    public static AdDto fromEntityToDto(Ad ad) {
        return AdDto.builder()
                .name(ad.getName())
                .mainPhoto(ad.getMainPhoto())
                .price(ad.getPrice())
                .description(ad.getDescription())
//                .otherPhotos(ad.getOtherPhotos())
                .build();
    }

    public static Ad fromDtoToEntity(AdDto adDto) {
        return Ad.builder()
                .name(adDto.getName())
                .mainPhoto(adDto.getMainPhoto())
                .price(adDto.getPrice())
                .description(adDto.getDescription())
//                .otherPhotos(adDto.getOtherPhotos())
//                .dateCreation(new Date())
                .build();
    }
}
