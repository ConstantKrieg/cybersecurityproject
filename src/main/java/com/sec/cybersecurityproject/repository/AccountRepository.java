
package com.sec.cybersecurityproject.repository;

import com.sec.cybersecurityproject.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Long> {
    
    Account findByUsername(String name);
}
