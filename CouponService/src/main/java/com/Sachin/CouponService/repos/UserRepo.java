package com.Sachin.CouponService.repos;
import com.Sachin.CouponService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>
{
    User findByEmail(String email);
}
