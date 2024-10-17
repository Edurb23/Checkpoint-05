package com.fiap.checkpoint.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CP_JV_ARTIST")
public class Artist {

    @Id
    @GeneratedValue
    @Column(name = "ID_ALBUM", length = 8)
    private Long id;

    @Column(name = "NM_ARTIST", length = 200, nullable = false)
    @NotBlank(message = "Artista é obrigatorio")
    private String artistName;




}
