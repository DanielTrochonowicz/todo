package com.example.todoapp.repositories;

import com.example.todoapp.models.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface Repository extends JpaRepository<Models, Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Models  m WHERE m.title=?1") //jpql
    void deleteByTitle(String title);

    @Query(value = "SELECT m FROM Models  m WHERE m.title=?1") //jpql
    Optional<Models> findByTitle(String title);
}
