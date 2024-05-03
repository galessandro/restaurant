package com.granados.location;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Location implements Serializable {

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer telephone;

    @Column(length = 128)
    private String address;

    @Column(nullable = false, length = 128)
    private String city;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private boolean status;

    public Location(String name, String email, Integer telephone, String address, String city, String description, boolean status) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.city = city;
        this.description = description;
        this.status = status;
    }

    public Location(Integer id, String name, String email, Integer telephone, String address, String city, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.city = city;
        this.description = description;
        this.status = status;
    }

    public Location() {}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getStatus() {
        return status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }


}
