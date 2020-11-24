package com.blanco.core.services;

import com.blanco.core.entities.Articulo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ArticuloServices {

    Articulo findById(Long id);

    List<Articulo> findAll();

    void saveArticulos (Articulo articulo);

    void updateArticulo(Articulo articulo);

    void deleteArticuloById(Long id);

    Boolean isExistArticulo(Articulo articulo);

}
