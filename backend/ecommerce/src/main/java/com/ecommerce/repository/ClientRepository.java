package com.ecommerce.repository;

import com.ecommerce.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByUserName(String userName);

    List<Client> findAll();

    void deleteByUserName(String userName);

}
