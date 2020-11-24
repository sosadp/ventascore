package com.blanco.core.controllers;

import com.blanco.core.dto.ArticuloDTO;
import com.blanco.core.entities.Articulo;
import com.blanco.core.services.ArticuloServices;
import com.blanco.core.utils.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticuloApiController {

    public static Logger LOGGER = LoggerFactory.getLogger(ArticuloApiController.class);

    final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    ArticuloServices articuloServices;

    @PostMapping
    public ResponseEntity<?> createArticulo(@RequestBody ArticuloDTO articuloDTO, UriComponentsBuilder ucBuilder){
        LOGGER.info("Iniciando creacion de Articulo");
        final Articulo articulo = this.modelMapper.map(articuloDTO,Articulo.class);
        if (articuloServices.isExistArticulo(articulo)){
            LOGGER.error("El articulo ya existe {}", articulo.getId());
            return  new ResponseEntity(new CustomErrorType("No se puede registrar el Articulo "+articulo.getId()), HttpStatus.CONFLICT);
        }

        articuloServices.saveArticulos(articulo);

        HttpHeaders headers = new HttpHeaders();

        headers.setLocation(ucBuilder.path("/articulo/{id}").buildAndExpand(articulo.getId()).toUri());

        return new ResponseEntity<String>(headers,HttpStatus.ACCEPTED);
    }


    @GetMapping("/articulo")
    public ResponseEntity<List<Articulo>> listAllArticulos(){
        LOGGER.info("Obteniendo la lista de Articulos");

        List<Articulo> articulos = articuloServices.findAll();

        if (articulos.isEmpty()){
            LOGGER.error("No hay informacion para mostrar");
            return new ResponseEntity( new CustomErrorType("No hay informacion para mostrar"),HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Articulo>>(articulos,HttpStatus.OK);

    }
}
