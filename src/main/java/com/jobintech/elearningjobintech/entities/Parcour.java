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
@Builder
public class Parcour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToMany(
            mappedBy = "parcours"
    )
    @JsonIgnoreProperties("parcours")
    private List<Users> users = new ArrayList<>();
   @JsonIgnore
    @OneToMany(mappedBy = "parcour",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Steps> steps = new ArrayList<>();


    public Parcour(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public Parcour(String title, String description, List<Users> users) {
        this.title = title;
        this.description = description;
        this.users = users;
    }

    public Parcour(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
