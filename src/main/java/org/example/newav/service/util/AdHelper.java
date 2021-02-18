package org.example.newav.service.util;

import org.example.newav.repository.dto.AdInDto;
import org.example.newav.repository.dto.AdOutDto;
import org.example.newav.repository.entity.Ad;
import org.example.newav.repository.mapper.AdMapper;
import org.springframework.data.domain.Sort;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdHelper {

    private static final int MAX_PHOTO = 3;
    private static final int MAX_TITLE_LEN = 200;
    private static final int MAX_DESC_LEN = 1000;
    private static final List<String> sorting;
    private static final List<String> columns;
    private static final String COLUMN_FOR_SORT = "creationDate";
    private static final String DESCRIPTION = "description";
    private static final String PHOTOS = "photos";

    static {
        sorting = new ArrayList<>();
        sorting.add("ASC");
        sorting.add("DESC");
        columns = new ArrayList<>();
        columns.add("creation_date");
        columns.add("price");
    }

    private AdHelper() {
    }

    public static AdOutDto getDtoFromAd(Ad ad, List<String> fields) {
        if (ad == null)
            return null;

        AdOutDto adOutDto = AdMapper.fromEntityToDto(ad);

        if (fields != null) {
            fields = fields.stream().map(s -> s = s.toLowerCase()).collect(Collectors.toList());
            if (!fields.contains(DESCRIPTION)) {
                adOutDto.setDescription(null);
            }
            if (!fields.contains(PHOTOS)) {
                adOutDto.setOtherPhotos(null);
            }
        } else {
            adOutDto.setDescription(null);
            adOutDto.setOtherPhotos(null);
        }
        return adOutDto;
    }

    public static Ad getAdFromDto(AdInDto adInDto) {
        if ((adInDto.getPhotos() != null && adInDto.getPhotos().size() > MAX_PHOTO) ||
                adInDto.getTitle() == null || adInDto.getTitle().length() > MAX_TITLE_LEN ||
                (adInDto.getDescription() != null && adInDto.getDescription().length() > MAX_DESC_LEN))
            return null;
        if (adInDto.getPhotos() != null) {
            try {
                URL url;
                for (String link: adInDto.getPhotos()) {
                    url = new URL(link);
                    url.toURI();
                }
            } catch (MalformedURLException | URISyntaxException e) {
                return null;
            }
        }
        return AdMapper.fromDtoToEntity(adInDto);
    }

    public static Sort getSort(String sort, String column) {
        sort = sort.toUpperCase();
        column = column.toLowerCase();

        boolean isAsc = false;
        if (sorting.contains(sort.toUpperCase())) {
            isAsc = !sort.equalsIgnoreCase(sorting.get(1));
        }
        if (!columns.contains(column) || column.equals(columns.get(0))) {
            column = COLUMN_FOR_SORT;
        }
        return (isAsc ? Sort.by(column).ascending() : Sort.by(column).descending());
    }

    public static AdOutDto getDtoForPages(Ad ad) {
        AdOutDto adOutDto = AdMapper.fromEntityToDto(ad);
        adOutDto.setDescription(null);
        adOutDto.setOtherPhotos(null);
        return adOutDto;
    }
}
