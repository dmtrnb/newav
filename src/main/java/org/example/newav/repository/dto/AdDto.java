package org.example.newav.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdDto implements Serializable {

    private String name;
    private String mainPhoto;
    private double price;
    @JsonIgnore
    private String description;
//    @JsonIgnore
//    private List<String> otherPhotos;
}
