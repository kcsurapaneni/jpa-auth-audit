package com.learn.jaa.domain.restaurant;

import jakarta.persistence.*;
import jakarta.persistence.ForeignKey;
import lombok.*;
import org.hibernate.annotations.*;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;

import java.time.*;
import java.util.*;

/**
 * @author Krishna Chaitanya
 */
@Setter
@Getter
@Entity(name = "client")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client implements UserDetails {

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String address;

    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "client_roles",
        joinColumns =
            @JoinColumn(
                    name = "client_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "client_roles_client_id")
            ),
        inverseJoinColumns =
            @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "client_roles_role_id")
            )
    )
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
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
