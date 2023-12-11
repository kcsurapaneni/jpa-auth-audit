package com.learn.jaa.repository.restaurant;

import com.learn.jaa.domain.restaurant.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByUsernameAndIsActiveTrue(String username);

}