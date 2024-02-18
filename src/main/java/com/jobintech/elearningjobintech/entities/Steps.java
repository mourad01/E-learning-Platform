package com.jobintech.elearningjobintech.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Builder
public class Steps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;
    @ManyToOne
    @JsonIgnoreProperties("steps")
    @JoinColumn(referencedColumnName = "id",
    name = "parcour-user-FK",
    nullable = false)
    private Parcour parcour;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "steps")
    private List<Learning> learnings = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "steps")
    private List<Doing> doing = new ArrayList<>();

    public Steps(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Steps(String title, String description, String status, Parcour parcour) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.parcour = parcour;
    }
}
