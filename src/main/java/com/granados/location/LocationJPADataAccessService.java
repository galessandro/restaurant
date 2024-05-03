package com.granados.location;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LocationJPADataAccessService implements LocationDao {

    private final LocationRepository locationRepository;

    public LocationJPADataAccessService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> selectAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> selectLocationById(Integer id) {
        return locationRepository.findById(id);
    }

    @Override
    public void insertLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public boolean existsLocationWithEmail(String email) {
        return locationRepository.existsLocationByEmail(email);
    }

    @Override
    public boolean existsLocationWithId(Integer id) {
        return locationRepository.existsLocationById(id);
    }

    @Override
    public void deleteLocationById(Integer locationId) {
        locationRepository.deleteById(locationId);
    }

    @Override
    public void updateLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void updateLocationAddress(Integer locationId, String address) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + locationId));

        location.setAddress(address);
        locationRepository.save(location);
    }

    @Override
    public void updateLocationCity(Integer locationId, String city) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + locationId));

        location.setCity(city);
        locationRepository.save(location);
    }

    @Override
    public void updateLocationDescription(Integer locationId, String description) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + locationId));

        location.setDescription(description);
        locationRepository.save(location);
    }

    @Override
    public void updateLocationStatus(Integer locationId, boolean status) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + locationId));

        location.setStatus(status);
        locationRepository.save(location);
    }
}
