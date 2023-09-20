package com.example.backend.hackbattle.service;

import com.example.backend.hackbattle.models.Skill;
import com.example.backend.hackbattle.models.SkillRepo;
import com.example.backend.hackbattle.models.UserInfo;
import com.example.backend.hackbattle.models.UserInfoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillUserInfoService {

    @Autowired
    private UserInfoRespository userInfoRepository;

    @Autowired
    private SkillRepo skillRepository;

    public void addSkillToUser(Integer userId, Integer skillId) {
        UserInfo userInfo = userInfoRepository.findById(userId).orElse(null);
        Skill skill = skillRepository.findById(skillId).orElse(null);
        if (userInfo != null && skill != null) {
            userInfo.getSkills().add(skill);
            userInfoRepository.save(userInfo);
        }
    }
}

