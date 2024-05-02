package com.granados.location;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getLocations(){
        return locationService.getAllLocations();
    }

    @GetMapping("{locationId}")
    public Location getLocation(@PathVariable("locationId") Integer locationId){
        return locationService.getLocation(locationId);
    }

    @PostMapping
    public void registerLocation(@RequestBody LocationRegistrationRequest request){
        locationService.addLocation(request);
    }

    @DeleteMapping("{locationId}")
    public void deleteLocation(@PathVariable("locationId") Integer locationId){
        locationService.deleteLocationById(locationId);
    }

    @PutMapping("{locationId}")
    public void updateLocation(
            @PathVariable("locationId") Integer locationId,
            @RequestBody LocationUpdateRequest updateRequest){
        locationService.updateLocation(locationId, updateRequest);
    }


    @PatchMapping("{locationId}/address")
    public void updateLocationAddress(
            @PathVariable("locationId") Integer locationId,
            @RequestBody String address){
        locationService.updateLocationAddress(locationId, address);
    }


    @PatchMapping("{locationId}/city")
    public void updateLocationCity(
            @PathVariable("locationId") Integer locationId,
            @RequestBody String city){
        locationService.updateLocationCity(locationId, city);
    }


    @PatchMapping("{locationId}/description")
    public void updateLocationDescription(
            @PathVariable("locationId") Integer locationId,
            @RequestBody String description){
        locationService.updateLocationDescription(locationId, description);
    }

    @PatchMapping("{locationId}/status") // Nuevo endpoint para actualizar el campo status
    public void updateLocationStatus(
            @PathVariable("locationId") Integer locationId,
            @RequestBody boolean status){
        locationService.updateLocationStatus(locationId, status);
    }
}
