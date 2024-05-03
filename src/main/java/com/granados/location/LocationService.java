package com.granados.location;

import com.granados.exception.DuplicateResourceException;
import com.granados.exception.RequestValidationException;
import com.granados.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationDao locationDao;

    public LocationService(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    public List<Location> getAllLocations(){
        return locationDao.selectAllLocations();
    }

    public Location getLocation(Integer id){
        return locationDao.selectLocationById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "location with id [%s] not found".formatted(id)
                ));
    }

    public void addLocation(LocationRegistrationRequest locationRegistrationRequest){
        if(locationDao.existsLocationWithEmail(locationRegistrationRequest.email())){
            throw new DuplicateResourceException("email already taken");
        }

        Location location = new Location(
                locationRegistrationRequest.name(),
                locationRegistrationRequest.email(),
                locationRegistrationRequest.telephone(),
                locationRegistrationRequest.address(),
                locationRegistrationRequest.city(),
                locationRegistrationRequest.description(),
                locationRegistrationRequest.status() // Agregar el campo status
        );

        locationDao.insertLocation(location);
    }

    public void deleteLocationById(Integer locationId) {
        if(!locationDao.existsLocationWithId(locationId)){
            throw  new ResourceNotFoundException(
                    "location with id [%s] not found".formatted(locationId)
            );
        }

        locationDao.deleteLocationById(locationId);
    }

    public void updateLocation(Integer locationId, LocationUpdateRequest updateRequest) {
        Location location = getLocation(locationId);

        boolean changes = false;

        if(updateRequest.name() != null && !updateRequest.name().equals(location.getName())){
            location.setName(updateRequest.name());
            changes = true;
        }

        if(updateRequest.telephone() != null && !updateRequest.telephone().equals(location.getTelephone())){
            location.setTelephone(updateRequest.telephone());
            changes = true;
        }

        if(updateRequest.email() != null && !updateRequest.email().equals(location.getEmail())){
            if (locationDao.existsLocationWithEmail(updateRequest.email())){
                throw new DuplicateResourceException("email already taken");
            }
            location.setEmail(updateRequest.email());
            changes = true;
        }

        if(updateRequest.address() != null && !updateRequest.address().equals(location.getAddress())){
            location.setAddress(updateRequest.address());
            changes = true;
        }

        if(updateRequest.city() != null && !updateRequest.city().equals(location.getCity())){
            location.setCity(updateRequest.city());
            changes = true;
        }

        if(updateRequest.description() != null && !updateRequest.description().equals(location.getDescription())){
            location.setDescription(updateRequest.description());
            changes = true;
        }

        if(updateRequest.status() != null && updateRequest.status() != location.getStatus()){
            location.setStatus(updateRequest.status());
            changes = true;
        }

        if(!changes){
            throw new RequestValidationException("no data changes found");
        }

        locationDao.updateLocation(location);
    }

    public void updateLocationAddress(Integer locationId, String address) {
        Location location = getLocation(locationId);
        location.setAddress(address);
        locationDao.updateLocation(location);
    }

    public void updateLocationCity(Integer locationId, String city) {
        Location location = getLocation(locationId);
        location.setCity(city);
        locationDao.updateLocation(location);
    }

    public void updateLocationDescription(Integer locationId, String description) {
        Location location = getLocation(locationId);
        location.setDescription(description);
        locationDao.updateLocation(location);
    }

    public void updateLocationStatus(Integer locationId, boolean status) {
        Location location = getLocation(locationId);
        location.setStatus(status);
        locationDao.updateLocation(location);
    }
}
