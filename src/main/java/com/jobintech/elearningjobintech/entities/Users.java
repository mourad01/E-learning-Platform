package com.jobintech.elearningjobintech.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonIgnoreProperties("users")

    @ManyToMany(
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    @JoinTable(name = "user_parcour",
            joinColumns = @JoinColumn(name = "user_id",
                    foreignKey= @ForeignKey(name = "enrollment_USER_id_FK")),

            inverseJoinColumns = @JoinColumn(name = "parcour_id",
                    foreignKey= @ForeignKey(name = "enrollment_PARCOUR_id_FK")))
    private List<Parcour> parcours = new ArrayList<>();

    public Users(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    public Users(Long id,String username,  String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.id = id;
    }
    public Users(String username, String password, String email, String role, List<Parcour> parcours) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.parcours = parcours;
    }



}
