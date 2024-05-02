package com.granados.location;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    boolean existsLocationByEmail(String email);
    boolean existsLocationById(Integer id);
    boolean existsLocationByAddress(String address);
    boolean existsLocationByCity(String city);
    boolean existsLocationByDescription(String description);
    boolean existsLocationByStatus(boolean status);
}
