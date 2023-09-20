package com.example.backend.hackbattle.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo extends JpaRepository<Skill,Integer>
{
    public Skill findBySkillname(String str);


}
