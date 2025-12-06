package com.jai.sprincloud.external;

import com.jai.sprincloud.dto.CouponDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${coupon.service.name}", url = "${coupon.service.url}")
public interface CouponClient {

    @GetMapping("/api/v1/coupons/{code}")
    CouponDto getCoupon(@PathVariable("code") String code );
}
