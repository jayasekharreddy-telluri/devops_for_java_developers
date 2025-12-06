package com.jai.sprincloud.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CouponDto(String code, BigDecimal discount, LocalDate expDate) {
}
