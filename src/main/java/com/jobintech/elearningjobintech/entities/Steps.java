package com.jobintech.elearningjobintech.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
