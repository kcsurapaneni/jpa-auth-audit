package com.learn.jaa.config.order;

import com.learn.jaa.repository.order.*;
import lombok.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

/**
 * @author Krishna Chaitanya
 */
@Component
@RequiredArgsConstructor
public class OrderUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository
                .findByUsernameAndIsActiveTrue(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
