package org.example.newav.repository.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdInDto implements Serializable {

    private String title;
    private List<String> photos;
    private double price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
}
