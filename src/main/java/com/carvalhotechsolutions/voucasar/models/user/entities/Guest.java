package com.carvalhotechsolutions.voucasar.models.user.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("GUEST")
@Entity
public class Guest extends User {

    private String name;

    @ManyToMany
    @JoinTable(
            name = "guest_present",
            joinColumns = @JoinColumn(name = "guest_id"),
            inverseJoinColumns = @JoinColumn(name = "present_id")
    )
    private List<Present> reserved_presents;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Couple couple;

}
