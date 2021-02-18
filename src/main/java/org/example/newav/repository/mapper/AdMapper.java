package org.example.newav.repository.mapper;

import org.example.newav.repository.dto.AdInDto;
import org.example.newav.repository.dto.AdOutDto;
import org.example.newav.repository.entity.Ad;

import java.util.List;
import java.util.Optional;

public class AdMapper {

    private AdMapper() {
    }

    public static AdOutDto fromEntityToDto(Ad ad) {
        List<String> photos = ad.getPhotos();
        Optional<String> mainPhoto = photos != null ? Optional.ofNullable(photos.get(0)) : Optional.empty();
        Optional<List<String>> otherPhotos = photos != null && photos.size() > 1 ?
                Optional.of(photos.subList(1, photos.size())) : Optional.empty();

        return AdOutDto.builder()
                .title(ad.getTitle())
                .mainPhoto(mainPhoto.orElse(null))
                .price(ad.getPrice())
                .description(ad.getDescription())
                .otherPhotos(otherPhotos.orElse(null))
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
