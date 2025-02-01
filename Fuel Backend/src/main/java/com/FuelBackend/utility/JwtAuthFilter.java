package com.FuelBackend.utility;

import com.FuelBackend.dataTransferObject.response.ExceptionResponseDTO;
import com.FuelBackend.exception.ForbiddenException;
import com.FuelBackend.exception.UnauthorizedAccessException;
import com.FuelBackend.utility.JwtUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtility jwtUtility;

    @Autowired
    public JwtAuthFilter(JwtUtility jwtUtility) {
        this.jwtUtility = jwtUtility;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            String authenticationHeader = request.getHeader("Authorization");

            if (StringUtils.hasText(authenticationHeader) && authenticationHeader.startsWith("Bearer ")) {
                String token = authenticationHeader.substring(7);
                String username = jwtUtility.extractUsername(token);

                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    if (jwtUtility.validateToken(token, username)) {
                        Collection<SimpleGrantedAuthority> authorities = jwtUtility.extractAuthorities(token);

                        UsernamePasswordAuthenticationToken authenticationToken =
                                new UsernamePasswordAuthenticationToken(username, null, authorities);
                        authenticationToken.setDetails(
                                new WebAuthenticationDetailsSource().buildDetails(request)
                        );
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }
            }

            filterChain.doFilter(request, response);

        } catch (UnauthorizedAccessException e) {
            System.out.println("UnauthorizedAccessException "+e.getMessage());
            writeErrorResponse(response, HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        } catch (ForbiddenException e) {
            System.out.println("ForbiddenException "+e.getMessage());
            writeErrorResponse(response, HttpStatus.FORBIDDEN.value(), e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception "+e.getMessage());
            writeErrorResponse(response, HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred.");
        }
    }

    private void writeErrorResponse(HttpServletResponse response, int status, String message) throws IOException {
        response.setStatus(status);
        response.setContentType("application/json");

        System.out.println("Error: "+message);
       /* response.getWriter().write(
                new ObjectMapper()(new ExceptionResponseDTO(false, message))
        );*/
        response.getWriter().flush();
    }
}
