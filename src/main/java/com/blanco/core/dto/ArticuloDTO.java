package com.blanco.core.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record ArticuloDTO(
    Long id,
    String nombre,
    String descripcion
) implements Serializable {
}
