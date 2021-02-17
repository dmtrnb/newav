package org.example.newav.repository.mapper;

import org.example.newav.repository.dto.AdDto;
import org.example.newav.repository.entity.Ad;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AdMapper {

    public static AdDto fromEntityToDto(Ad ad) {
        List<String> photos = ad.getPhotos();
        int size = photos != null ? photos.size() : 0;

        return AdDto.builder()
                .name(ad.getName())
                .mainPhoto(size > 0 ? photos.get(0) : null)
                .price(ad.getPrice())
                .description(ad.getDescription())
                .otherPhotos(size > 1 ? photos.subList(1, size) : null)
                .build();
    }

    public static Ad fromDtoToEntity(AdDto adDto) {
        List<String> photos = new ArrayList<>();

        photos.add(adDto.getMainPhoto());
        photos.addAll(adDto.getOtherPhotos());

        return Ad.builder()
                .name(adDto.getName())
                .price(adDto.getPrice())
                .description(adDto.getDescription())
                .photos(photos)
                .dateCreation(new Timestamp(System.currentTimeMillis()))
                .build();
    }
}
