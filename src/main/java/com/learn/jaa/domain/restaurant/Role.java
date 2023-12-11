package com.learn.jaa.domain.restaurant;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.*;

/**
 * @author Krishna Chaitanya
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive;

    @Override
    public String getAuthority() {
        return this.name;
    }

}
