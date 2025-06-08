package com.edutech.classroom.dto;

import com.edutech.classroom.entity.DiscountCoupon;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DiscountCouponDTO {
    private Integer id;

    @Size(max = 50, message = "El codigo debe tener un máximo de 50 caracteres")
    @NotBlank(message = "El codigo no puede estar vacio")
    private String code;

    @Size(max = 800, message = "La descripción tiene un maximo de 800 caracteres")
    @NotBlank(message = "La descripción no puede estar vacia")
    private String description;

    @NotNull
    private BigDecimal discountPercentage;

    @NotNull
    private LocalDate validFrom;

    @NotNull
    private LocalDate validUntil;

    @NotNull
    private Boolean isActive;

    public static DiscountCouponDTO fromEntity(DiscountCoupon entity) {
        DiscountCouponDTO dto = new DiscountCouponDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        dto.setDiscountPercentage(entity.getDiscountPercentage());
        dto.setValidFrom(entity.getValidFrom());
        dto.setValidUntil(entity.getValidUntil());
        dto.setIsActive(entity.getIsActive());
        return dto;
    }

    public DiscountCoupon toEntity() {
        DiscountCoupon entity = new DiscountCoupon();
        entity.setId(this.getId());
        entity.setCode(this.getCode());
        entity.setDescription(this.getDescription());
        entity.setDiscountPercentage(this.getDiscountPercentage());
        entity.setValidFrom(this.getValidFrom());
        entity.setValidUntil(this.getValidUntil());
        entity.setIsActive(this.getIsActive());
        return entity;
    }
}
