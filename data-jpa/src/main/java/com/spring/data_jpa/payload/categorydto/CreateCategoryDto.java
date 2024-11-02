package com.spring.data_jpa.payload.categorydto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateCategoryDto {

    @NotNull
    @Size(min = 5, message = "category size minimum 5 characters")
//    NotEmpty
    private String categoryName;
}
