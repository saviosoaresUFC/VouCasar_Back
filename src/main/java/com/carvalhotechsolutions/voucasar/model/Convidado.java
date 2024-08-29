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
public class Convidado extends Usuario {

    @Column(unique=true, nullable = false)
    private String nome;

    @OneToMany
    private List<Presente> presentes_reservados;

    @ManyToOne(cascade = CascadeType.ALL)
    private Casal casal;


}
