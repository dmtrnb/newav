package org.example.newav.repository.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "Описание и фото опционально")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdInDto implements Serializable {

    @ApiModelProperty(example = "Title", position = 0)
    private String title;
    @ApiModelProperty(example = "[file:///C:/my, https://intern.in, ftp://avito.ru]", position = 1)
    private List<String> photos;
    @ApiModelProperty(example = "2.28", position = 2)
    private double price;
    @ApiModelProperty(example = "description", position = 3)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
}
