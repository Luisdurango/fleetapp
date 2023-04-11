package com.springconsole.fleetapp;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpringSecurityAuditor implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = Optional.ofNullable(authentication)
                .map(Authentication::getName)
                .orElseGet( () -> "defaultUsername");

        return Optional.ofNullable(username).filter(s-> s != null && !s.isEmpty());

//    String username = authentication.getName();
//    return Optional.ofNullable(username).filter(s -> s != null && !s.isEmpty());
    }
}
