package com.jai.springcloud.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true, length = 20)
    private String code;

    @Column(name = "discount", nullable = false, precision = 8, scale = 3)
    private BigDecimal discount;

    @Column(name = "exp_date", nullable = false)
    private LocalDate expDate;

    // ---------------- Constructors ----------------

    public Coupon() {
    }

    public Coupon(String code, BigDecimal discount, LocalDate expDate) {
        this.code = code;
        this.discount = discount;
        this.expDate = expDate;
    }

    // ---------------- Getters & Setters ----------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    // ---------------- Convenience Methods ----------------

    public boolean isExpired() {
        return expDate.isBefore(LocalDate.now());
    }

    // ---------------- toString ----------------

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", discount=" + discount +
                ", expDate=" + expDate +
                '}';
    }
}
