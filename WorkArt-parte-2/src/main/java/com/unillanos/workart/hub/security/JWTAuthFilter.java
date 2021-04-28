package com.unillanos.workart.hub.security;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class JWTAuthFilter extends OncePerRequestFilter {

    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer";
    private final String SECRET = "thisissecret";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            if (checkToken(httpServletRequest, httpServletResponse)) {
                Claims claims = validateToken(httpServletRequest);

                if (!claims.isEmpty())
                    setSpringAuth(claims.getSubject());
                else
                    SecurityContextHolder.clearContext();

                filterChain.doFilter(httpServletRequest, httpServletResponse);
            } else {
                SecurityContextHolder.clearContext();
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            }
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);

            ((HttpServletResponse) httpServletResponse).sendError(HttpServletResponse.SC_FORBIDDEN, ex.getMessage());

        }

    }

    private Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");

        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();

    }

    private void setSpringAuth(String username) {
        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(username,
                        null,
                        Arrays.asList(new SimpleGrantedAuthority("prueba")));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private boolean checkToken(HttpServletRequest request,HttpServletResponse
            response)
    {
        String authenticationHeader=request.getHeader(HEADER);
        if (authenticationHeader==null ||
            !authenticationHeader.startsWith(PREFIX))
            return false;
        return true;
    }
}
