package com.granados.location;

public record LocationRegistrationRequest (
        String name,
        String email,
        Integer telephone,
        String address,
        String city,
        String description,
        boolean status) {
}
