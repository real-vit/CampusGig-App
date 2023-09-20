package com.example.backend.hackbattle.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userinfo")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonBackReference(value = "userinfo")
    @OneToOne(mappedBy = "userInfo", cascade = CascadeType.ALL)
    private User user;

    public User user() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "description")
    private String desc;

    @Column(name = "resumeimage")
    private String image;


    @ManyToMany(cascade = CascadeType.ALL
            ,fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_skill",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    public void addSkill(Skill skill)
    {
        if(skills==null)
        {
            skills=new ArrayList<>();
        }
        skills.add(skill);
    }

}
