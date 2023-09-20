package com.example.backend.hackbattle.auth;

import com.example.backend.hackbattle.models.Skill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customuser {
    private String desc;
    private String Image;
    private String skills;
}