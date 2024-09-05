package com.carvalhotechsolutions.voucasar.model;

import com.carvalhotechsolutions.voucasar.model.enums.Role;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Removi o atributo nome, pois tanto convidado quanto
    // casal irão herdar usuario, e casal tem um tipo especifico
    // que é nome_noiva e nome_noivo, então não faz sentido deixar
    // um atributo nome aqui.

}
