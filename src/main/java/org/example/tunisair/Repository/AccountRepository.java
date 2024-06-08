package org.example.tunisair.Repository;

import org.example.tunisair.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {


    Optional<Account> findByEmail(String email);

}
