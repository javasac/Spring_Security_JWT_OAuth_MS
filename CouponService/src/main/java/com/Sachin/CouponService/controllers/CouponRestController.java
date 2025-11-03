package com.Sachin.CouponService.controllers;
import com.Sachin.CouponService.model.Coupon;
import com.Sachin.CouponService.repos.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
@CrossOrigin
public class CouponRestController
{
    @Autowired
    private CouponRepo couponRepo;

    @GetMapping("/search/id/{id}")
    public Coupon findByID(@PathVariable int id)
    {
        return couponRepo.findById(id).orElse(null);
    }

    @GetMapping("/search/code/{code}")
    @PostAuthorize("returnObject.discount < 500")
    public Coupon findByCode(@PathVariable String code)
    {
        return couponRepo.findByCode(code);
    }

    @PostMapping("/add")
    public Coupon create(@RequestBody Coupon coupon)
    {
        return couponRepo.save(coupon);
    }

    @GetMapping("/test")
    public String test()
    {
        return "test";
    }
}
