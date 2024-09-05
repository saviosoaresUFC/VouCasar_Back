package com.carvalhotechsolutions.voucasar.model;

import com.carvalhotechsolutions.voucasar.model.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String description;

    private String url_image;

    @ManyToMany(mappedBy = "gifts")
    private List<Couple> couples;

    private boolean reserved;

}
