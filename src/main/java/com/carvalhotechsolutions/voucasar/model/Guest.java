package com.carvalhotechsolutions.voucasar.model;

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
@Entity
public class Guest extends User {

    @Column(unique=true, nullable = false)
    private String name;

    @OneToMany
    private List<Gift> reserved_gifts;

    @ManyToOne(cascade = CascadeType.ALL)
    private Couple couple;


}
