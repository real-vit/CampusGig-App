package com.example.backend.hackbattle.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "skill_name")
    private String skillname;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL
    ,fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_skill",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<UserInfo> users;

    public List<UserInfo> users() {
        return users;
    }

    public void setUsers(UserInfo userInfo) {
        if(users==null)
        {
            users=new ArrayList<>();
        }
        users.add(userInfo);
    }
}

