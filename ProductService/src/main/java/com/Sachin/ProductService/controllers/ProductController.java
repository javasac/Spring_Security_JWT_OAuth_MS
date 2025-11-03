package com.Sachin.ProductService.controllers;
import com.Sachin.ProductService.dto.Coupon;
import com.Sachin.ProductService.model.Product;
import com.Sachin.ProductService.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${couponService.url}")
    private String couponUrl;

    @GetMapping("/id/{id}")
    public Product findByID(@PathVariable int id)
    {
        return productRepo.findById(id).orElse(null);
    }

    @GetMapping("/code/{code}")
    public Product findByCode(@PathVariable String code)
    {
        return productRepo.findByName(code);
    }

    @PostMapping("/add")
    public Product create(@RequestBody Product product)
    {
        Coupon cp = restTemplate.getForObject(couponUrl + product.getCouponCode(), Coupon.class);
        product.setPrice(product.getPrice().subtract(cp.getDiscount()));

        return productRepo.save(product);
    }

    @GetMapping("/test")
    public String product()
    {
        return "Product";
    }
}
