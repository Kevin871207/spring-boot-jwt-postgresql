package com.kevin.spring.security.postgresql.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GetBookStatusRequest {
    @NotBlank
    private Long inventoryId;

    @NotBlank
    private Long userId;

}
