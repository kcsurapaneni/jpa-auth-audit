package com.learn.jaa.config.restaurant;

import com.learn.jaa.repository.restaurant.*;
import lombok.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

/**
 * @author Krishna Chaitanya
 */
@Component
@RequiredArgsConstructor
public class RestaurantUserDetailsService implements UserDetailsService {

    private final ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clientRepository
                .findByUsernameAndIsActiveTrue(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

}
