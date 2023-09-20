package com.example.backend.hackbattle.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "budget")
    private float budget;

    @Column(name = "date")
    private String date;

    public User user() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "status")
    private Boolean status;

    @JsonBackReference(value = "userproject")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;


}

