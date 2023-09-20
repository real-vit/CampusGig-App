package com.example.backend.hackbattle.models;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UseRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u")
    List<User> findAllUsers();
}