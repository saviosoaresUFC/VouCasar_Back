package com.carvalhotechsolutions.voucasar.model;

import com.carvalhotechsolutions.voucasar.model.enums.PreferenciaCores;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Casal extends Usuario {

    @Column(nullable = false)
    private String nome_noivo;

    @Column(nullable = false)
    private String nome_noiva;

    @Column(nullable = false)
    private String cidade;

    @Column(unique=true, nullable = false)
    private String fotoCasal;

    @Enumerated(EnumType.STRING)
    private PreferenciaCores preferenciaCores;

    @OneToMany(mappedBy = "casal", fetch = FetchType.EAGER)
    private List<Convidado> convidados;

    @ManyToMany
    @JoinTable(
            name = "casal_presente",
            joinColumns = @JoinColumn(name = "casal_id"),
            inverseJoinColumns = @JoinColumn(name = "presente_id")
    )
    private List<Presente> presentes;

}
