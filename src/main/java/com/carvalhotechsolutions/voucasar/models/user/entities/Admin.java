package com.carvalhotechsolutions.voucasar.models.user.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("ADMIN")
@Entity
public class Admin extends User {

    private String name;

}
