package com.learn.jaa.repository.order;

import com.learn.jaa.domain.order.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByUsernameAndIsActiveTrue(String username);

}