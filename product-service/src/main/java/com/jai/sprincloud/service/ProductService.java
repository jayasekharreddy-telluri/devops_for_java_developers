package com.jai.sprincloud.service;

import com.jai.sprincloud.dto.CouponDto;
import com.jai.sprincloud.external.CouponClient;
import com.jai.sprincloud.model.Product;
import com.jai.sprincloud.repos.ProductRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    private final CouponClient couponClient;

    public ProductService(ProductRepo productRepo, CouponClient couponClient) {
        this.productRepo = productRepo;
        this.couponClient = couponClient;
    }

    public Product saveProduct(Product product) {

        if(product.getCode() != null) {  // change here
            System.out.println("Fetching coupon for code: " + product.getCode());

            CouponDto couponDto = couponClient.getCoupon(product.getCode());

            if (couponDto != null) {
                product.setPrice(product.getPrice().subtract(couponDto.discount()));
            }
        }

        return productRepo.save(product);
    }

}
