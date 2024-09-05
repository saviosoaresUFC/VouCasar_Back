package com.carvalhotechsolutions.voucasar.model;

import com.carvalhotechsolutions.voucasar.model.enums.ColorPreference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Couple extends User {

    @Column(nullable = false)
    private String name_groom;

    @Column(nullable = false)
    private String name_bride;

    @Column(nullable = false)
    private String city;

    @Column(unique=true, nullable = false)
    private String url_image;

    @Enumerated(EnumType.STRING)
    private ColorPreference colorPreference;

    @OneToMany(mappedBy = "couple", fetch = FetchType.EAGER)
    private List<Guest> guests;

    @ManyToMany
    @JoinTable(
            name = "couple_gift",
            joinColumns = @JoinColumn(name = "couple_id"),
            inverseJoinColumns = @JoinColumn(name = "gift_id")
    )
    private List<Gift> gifts;

}
