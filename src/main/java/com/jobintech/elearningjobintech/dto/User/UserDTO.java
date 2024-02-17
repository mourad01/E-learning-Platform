package com.jobintech.elearningjobintech.dto.User;

import com.jobintech.elearningjobintech.dto.parcour.ParcourDTO;

import java.util.List;

public record UserDTO(Long id, String username, String email, String role, List<ParcourDTO> parcours) {
}
