package com.jobintech.elearningjobintech.dto.parcour;

import com.jobintech.elearningjobintech.entities.Users;

import java.util.List;

public record ParcourRegistration(String title, String description, List<Users> user) {

}
