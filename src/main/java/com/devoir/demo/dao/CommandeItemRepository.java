package com.devoir.demo.dao;

import com.devoir.demo.entities.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeItemRepository extends JpaRepository<CommandeItem,Long> {
}
