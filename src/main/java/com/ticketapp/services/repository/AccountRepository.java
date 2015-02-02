package com.ticketapp.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketapp.services.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
