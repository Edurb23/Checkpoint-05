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
@Table(name = "TB_CP_JV_COVER")
public class Cover {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="URL_COVER", nullable = false, length = 200)
    @NotBlank(message = "Imagem é obrigatória")
    private String coverURL;
}
