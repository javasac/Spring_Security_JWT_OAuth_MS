package com.Sachin.CouponService.repos;
import com.Sachin.CouponService.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon, Integer>
{
    Coupon findByCode(String code);
}
