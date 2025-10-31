package com.sachin.SecurityJWT.Controller;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{
    @GetMapping("/encode/{pwd}")
    public String encodePassword(@PathVariable String pwd)
    {
        System.out.println("User sent password = " + pwd);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encPwd = passwordEncoder.encode(pwd);

        System.out.println("Encoded password: " + encPwd);

        boolean matches = passwordEncoder.matches(pwd, encPwd);
        System.out.println("Password matches: " + matches);

        return encPwd;
    }

    @GetMapping("/name")
    public String name()
    {
        return "Sachin Kansal";
    }

    @GetMapping("/bye")
    public String bye()
    {
        return "get lost !!";
    }
}
