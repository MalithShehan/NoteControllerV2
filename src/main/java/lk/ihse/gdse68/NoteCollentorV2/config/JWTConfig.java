package lk.ihse.gdse68.NoteCollentorV2.config;

import ch.qos.logback.core.util.StringUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Configuration
@RequiredArgsConstructor
public class JWTConfig extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String initToken = request.getHeader("Authorization");
        String userEmail;
        String jwtToken;

        if(StringUtil.isEmty(initToken)) || !initToken.startsWith("Barer")
    }
}
