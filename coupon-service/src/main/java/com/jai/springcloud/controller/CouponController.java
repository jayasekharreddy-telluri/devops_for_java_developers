package com.jai.springcloud.controller;

import com.jai.springcloud.model.Coupon;
import com.jai.springcloud.service.CouponService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/coupons")
public class CouponController {
    private final CouponService couponService;

    public CouponController(CouponService couponService) { this.couponService = couponService; }

    @PostMapping
    public ResponseEntity<Coupon> addCoupon(@RequestBody Coupon coupon) {
        Coupon saved = couponService.saveCoupon(coupon);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Coupon> getCouponByCode(@PathVariable String code) {
        Coupon coupon = couponService.getCouponByCode(code);
        if (coupon == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(coupon);
    }

    @GetMapping
    public String get() {
        return "jai";
    }

}

