package com.Sachin.ProductService.repos;
import com.Sachin.ProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer>
{
    Product findByName(String name);
}
