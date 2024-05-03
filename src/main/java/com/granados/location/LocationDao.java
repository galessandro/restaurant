package com.granados.location;

import java.util.List;
import java.util.Optional;

public interface LocationDao {

    List<Location> selectAllLocations();
    Optional<Location> selectLocationById(Integer id);
    void insertLocation(Location location);
    boolean existsLocationWithEmail(String email);
    boolean existsLocationWithId(Integer id);

    void deleteLocationById(Integer locationId);

    void updateLocation(Location location);

    void updateLocationAddress(Integer locationId, String address);

    void updateLocationCity(Integer locationId, String city);

    void updateLocationDescription(Integer locationId, String description);

    void updateLocationStatus(Integer locationId, boolean status); // Nuevo método para actualizar el campo status
}
