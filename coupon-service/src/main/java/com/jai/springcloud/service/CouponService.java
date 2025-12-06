package com.jai.springcloud.service;

import com.jai.springcloud.model.Coupon;
import com.jai.springcloud.repos.CouponRepo;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    private final CouponRepo couponRepo;
    public CouponService(CouponRepo couponRepo) { this.couponRepo = couponRepo; }

    public Coupon saveCoupon(Coupon coupon) {
        return couponRepo.save(coupon);
    }

    public Coupon getCouponByCode(String code) {
        return couponRepo.findByCode(code);
    }
}
