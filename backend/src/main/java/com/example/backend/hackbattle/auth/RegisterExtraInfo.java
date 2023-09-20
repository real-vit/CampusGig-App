package com.example.backend.hackbattle.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterExtraInfo
{
    private String skill;
    private String desc;
    private String resumeimage;
}
