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
public class Parcour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    @JsonIgnoreProperties("parcours")
    @JoinColumn(name = "user_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_USER_PARCOUR")
    )
    private Users user;

    @OneToMany(mappedBy = "parcour",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Steps> steps = new ArrayList<>();


    public Parcour(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
