package org.example.newav.repository.mapper;

import org.example.newav.repository.dto.AdInDto;
import org.example.newav.repository.dto.AdOutDto;
import org.example.newav.repository.entity.Ad;

import java.util.List;

public class AdMapper {

    public static AdOutDto fromEntityToDto(Ad ad) {
        List<String> photos = ad.getPhotos();
        int size = photos != null ? photos.size() : 0;

        return AdOutDto.builder()
                .title(ad.getTitle())
                .mainPhoto(size > 0 ? photos.get(0) : null)
                .price(ad.getPrice())
                .description(ad.getDescription())
                .otherPhotos(size > 1 ? photos.subList(1, size) : null)
                .build();
    }

    public static Ad fromDtoToEntity(AdInDto adInDto) {
        return Ad.builder()
                .title(adInDto.getTitle())
                .price(adInDto.getPrice())
                .description(adInDto.getDescription())
                .photos(adInDto.getPhotos())
                .build();
    }
}
