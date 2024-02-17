package com.jobintech.elearningjobintech.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String role;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Parcour> parcours = new ArrayList<>();

    public Users(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    public Users(String username, String password, String email, String role, List<Parcour> parcours) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.parcours = parcours;
    }

    public void addParcour(Parcour parcour) {
        if (!this.parcours.contains(parcour)){
            this.parcours.add(parcour);
            parcour.setUser(this);
        }

    }


}
