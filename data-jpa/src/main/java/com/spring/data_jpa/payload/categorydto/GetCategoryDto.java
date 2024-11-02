package com.spring.data_jpa.payload.categorydto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GetCategoryDto {
    private String categoryName;
}
