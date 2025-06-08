package com.edutech.classroom.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DiscountCouponDTO {
    private Integer id;
    private String code;
    private String description;
    private BigDecimal discountPercentage;

}
