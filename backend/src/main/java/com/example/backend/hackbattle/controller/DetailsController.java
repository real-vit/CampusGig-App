package com.example.backend.hackbattle.controller;

import com.example.backend.hackbattle.auth.Customuser;
import com.example.backend.hackbattle.models.*;
import com.example.backend.hackbattle.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class DetailsController {

    private final UserInfoRespository userInfoRepository;
    private final UseRepository repository;
    private final JwtService jwtService;
    private final SkillRepo skillRepo;

    @PostMapping("/AddDetails")
    public ResponseEntity<String> addUserInfo(@RequestHeader("Authorization") String jwtToken, @RequestBody Customuser customuser) {
        final String jwt;
        final String userEmail;
        if (jwtToken == null || !jwtToken.startsWith("Bearer ")) {
            throw new RuntimeException("invalid token");
        }
        jwt = jwtToken.substring(7);
        userEmail = jwtService.extractUsername(jwt);
        var user = repository.findByEmail(userEmail)
                .orElseThrow();
        if (user!=null) {
            UserInfo existingUserInfo = user.getUserInfo();
            if (existingUserInfo == null) {
                existingUserInfo = new UserInfo();
            }
            existingUserInfo.setImage(customuser.getImage());
            existingUserInfo.setDesc(customuser.getDesc());
            String[] skillsList = customuser.getSkills().split(" ");
            for (String skillName : skillsList) {
                Skill skill = skillRepo.findBySkillname(skillName);
                if (skill != null) {
                    existingUserInfo.addSkill(skill);
                }
            }
            user.setUserInfo(existingUserInfo);
            userInfoRepository.save(existingUserInfo);
            return ResponseEntity.ok("UserInfo updated successfully");
        }
        else {
            return ResponseEntity.ok("Wrong User Details");
        }
    }

    @GetMapping("/details")
    public ResponseEntity<User> UserDetails(@RequestHeader("Authorization") String jwtToken) {
        final String jwt;
        final String userEmail;
        if (jwtToken == null || !jwtToken.startsWith("Bearer ")) {
            throw new RuntimeException("invalid token");
        }
        jwt = jwtToken.substring(7);
        userEmail = jwtService.extractUsername(jwt);
        var user = repository.findByEmail(userEmail)
                .orElseThrow();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user")
    public ResponseEntity<String> getCurrentUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            return ResponseEntity.ok("Current User: " + username);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authenticated");
        }
    }
}
