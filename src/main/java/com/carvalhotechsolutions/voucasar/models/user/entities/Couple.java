package com.carvalhotechsolutions.voucasar.models.user.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@DiscriminatorValue("COUPLE")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Couple extends User {

    private String name_groom;

    private String name_bride;

    private String city;

    private String url_image;

    @ElementCollection
    @CollectionTable(name = "user_color_preferences", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "color_preferences")
    private List<String> colorPreferences;

    @ManyToMany(mappedBy = "couples")
    private List<Present> presents;

    @OneToMany(mappedBy = "couple", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Guest> guests;

}
