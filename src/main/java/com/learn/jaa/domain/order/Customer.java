package com.learn.jaa.domain.order;

import jakarta.persistence.*;
import jakarta.persistence.ForeignKey;
import lombok.*;
import lombok.extern.slf4j.*;
import org.hibernate.annotations.*;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;

import java.time.*;
import java.util.*;

/**
 * @author Krishna Chaitanya
 */
@Entity(name = "customer")
@Setter
@Getter
@Slf4j
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer implements UserDetails {

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "authority_id", nullable = false, foreignKey = @ForeignKey(name = "customer_authority_id"))
    private Authority authority;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;

    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("Authority : {}", this.authority.getAuthority());
        return List.of(this.authority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
