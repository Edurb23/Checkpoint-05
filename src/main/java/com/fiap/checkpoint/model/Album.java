package com.fiap.checkpoint.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CP_JV_ALBUM")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração de ID configurada corretamente
    @Column(name = "ID_ALBUM", length = 8)
    private Long id;

    @Column(name = "NM_ALBUM", length = 50, nullable = false, unique = true)
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 50)
    private String nome;

    @Column(name = "DS_ALBUM", length = 200, nullable = false)
    @NotBlank(message = "Descrição é obrigatória")
    private String about;

    @Enumerated(EnumType.STRING)
    @Column(name = "DS_GEN", length = 30, nullable = false)
    private GenMusic genMusic;

    @Column(name = "DT_LANCAMENTO")
    @Past(message = "A data de lançamento deve ser no passado")
    private LocalDate dataLacamento;

    @ManyToOne
    @JoinColumn(name = "ID_ARTISTA")
    private Artist artist;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="COVER_ID")
    private Cover cover;
}
