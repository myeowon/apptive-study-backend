package com.yeowon.demo.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductRequest(
        @NotBlank(message = "상품의 이름은 필수입니다.")
        @Size(min = 1, max = 5, message = "이름은 1 ~ 5자 사이여야 합니다.")
        String name,

        @Min(value = 1000, message = "가격은 최소 1000원 이상이어야 합니다.")
        @Max(value = 5000, message = "가격은 최대 5000원 이하여야 합니다.")
        Integer price,

        @Max(value = 999, message = "수량은 최대 999개여야 합니다.")
        Integer quantity
)
{}
