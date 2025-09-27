package com.blanco.core.dto;


import lombok.Builder;

import java.io.Serializable;

@Builder
public record CategoryDTO(Long id,
                          String nombre,
                          String descripcion) implements Serializable { }
