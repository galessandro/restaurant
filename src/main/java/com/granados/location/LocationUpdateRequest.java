package com.granados.location;

public record LocationUpdateRequest(
        String name,
        String email,
        Integer telephone,
        String address,
        String city,
        String description,
        Boolean status) {
}
