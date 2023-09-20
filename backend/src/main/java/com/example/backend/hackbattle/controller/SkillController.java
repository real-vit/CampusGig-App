package com.example.backend.hackbattle.controller;

import com.example.backend.hackbattle.models.Skill;
import com.example.backend.hackbattle.models.SkillRepo;
import com.example.backend.hackbattle.service.SkillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    SkillRepo skillRepo;

    @PostMapping("/add")
    public Skill addSkills(@RequestBody SkillDTO skills) {
        // Create Skill entities and save them to the database
        Skill skill= Skill.builder()
                .description(skills.getDescription())
                .skillname(skills.getSkillName())
                .build();
        skillRepo.save(skill);
        return skill;
    }
}
