package com.sachin.SecurityJWT.security;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import java.util.Arrays;

public class MyAuthenticationProvider implements AuthenticationProvider
{
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException
    {
        String user = auth.getName();
        String pwd = auth.getCredentials().toString();
        System.out.println(user + ", " + pwd);

        if ("tom".equals(user) && "cruise".equals(pwd))
        {
            return new UsernamePasswordAuthenticationToken(user, pwd, Arrays.asList());
        }
        else
        {
            throw new BadCredentialsException("Invalid Username or Password");
        }
    }

    @Override
    public boolean supports(Class<?> auth)
    {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
