package com.carvalhotechsolutions.voucasar.models.user.entities;

import com.carvalhotechsolutions.voucasar.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_present")
@Entity
public class Present {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private Category category;

    private String description;

    private String url_image;

    @ManyToMany
    @JoinTable(
            name = "couple_present",
            joinColumns = @JoinColumn(name = "present_id"),
            inverseJoinColumns = @JoinColumn(name = "couple_id")
    )
    private List<Couple> couples;

    @ManyToMany(mappedBy = "reserved_presents")
    private List<Guest> guests;

}
