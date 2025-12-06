package com.jai.springcloud.repos;

import com.jai.springcloud.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends JpaRepository<Coupon,Long> {

    Coupon findByCode(String code);
}
