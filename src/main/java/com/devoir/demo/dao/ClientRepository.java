package com.devoir.demo.dao;

import com.devoir.demo.entities.Client;
import com.devoir.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,String> {
        Client findByUser(User user);
}
