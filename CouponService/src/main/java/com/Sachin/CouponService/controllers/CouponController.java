package com.Sachin.CouponService.controllers;
import com.Sachin.CouponService.model.Coupon;
import com.Sachin.CouponService.repos.CouponRepo;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CouponController
{
	@Autowired
	private CouponRepo repo;

	@GetMapping("/showCreateCoupon")
	@PreAuthorize("hasRole('ADMIN')")
	//@RolesAllowed("ADMIN")
	public String showCreateCoupon()
	{
		return "createCoupon";
	}

	@PostMapping("/saveCoupon")
	public String save(Coupon coupon)
	{
		repo.save(coupon);
		return "createResponse";
	}

	@GetMapping("/showGetCoupon")
	public String showGetCoupon()
	{
		return "getCoupon";
	}

	@PostMapping("/getCoupon")
	public ModelAndView getCoupon(String code)
	{
		ModelAndView mav = new ModelAndView("couponDetails");
		System.out.println(code);
		mav.addObject(repo.findByCode(code));
		return mav;
	}
}
