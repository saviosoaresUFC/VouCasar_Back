package com.carvalhotechsolutions.voucasar.model;

import com.carvalhotechsolutions.voucasar.model.enums.Categoria;
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
public class Presente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private String descricao;

    private String url_imagem;

    @ManyToMany(mappedBy = "presentes")
    private List<Casal> casais;

    private boolean reservado;

}
