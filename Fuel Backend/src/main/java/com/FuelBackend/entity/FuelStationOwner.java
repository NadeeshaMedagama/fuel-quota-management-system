package com.FuelBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FuelStationOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ownerName;

    private String contactNumber;

    private String email;

    private String address;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "loginid", nullable = false)
//    @JsonIgnore
//    private UserLog ownerLog;
}
