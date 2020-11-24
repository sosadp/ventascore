package com.blanco.core.services.impl;

import com.blanco.core.entities.Articulo;
import com.blanco.core.repositories.ArticuloRepository;
import com.blanco.core.services.ArticuloServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ArticuloServicesImpl  implements ArticuloServices {

    public static Logger LOGGER = LoggerFactory.getLogger(ArticuloServicesImpl.class);

    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public Articulo findById(Long id) {
        return articuloRepository.getOne(id);
    }

    @Override
    public List<Articulo> findAll() {
        return articuloRepository.findAll();
    }

    @Override
    public void saveArticulos(Articulo articulo) {
        articuloRepository.save(articulo);
    }

    @Override
    public void updateArticulo(Articulo articulo) {
        saveArticulos(articulo);
    }

    @Override
    public void deleteArticuloById(Long id) {
        articuloRepository.deleteById(id);
    }

    @Override
    public Boolean isExistArticulo(Articulo articulo) {
        return articuloRepository.existsById(articulo.getId());
    }
}
