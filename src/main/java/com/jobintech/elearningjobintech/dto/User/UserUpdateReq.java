package com.jobintech.elearningjobintech.dto.User;

import com.jobintech.elearningjobintech.entities.Parcour;

import java.util.List;

public record UserUpdateReq(String username , String role, List<Parcour> parcours) {
}
