package com.example.backend.hackbattle.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRespository extends JpaRepository<UserInfo, Integer>
{
    Optional<UserInfo> findById(Integer id);
}
