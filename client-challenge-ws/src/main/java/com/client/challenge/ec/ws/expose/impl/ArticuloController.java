package com.client.challenge.ec.ws.expose.impl;

import com.client.challenge.ec.bs.service.impl.ArticuloServiceImpl;
import com.client.challenge.ec.bs.utils.GenericConverterUtils;
import com.client.challenge.ec.ds.dto.ArticuloDTO;
import com.client.challenge.ec.ds.entity.Articulo;
import com.client.challenge.ec.ws.expose.IArticuloController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ArticuloController implements IArticuloController {

    private final ArticuloServiceImpl articuloService;

    private final GenericConverterUtils genericConverterUtils;

    @Autowired
    public ArticuloController(ArticuloServiceImpl articuloService, GenericConverterUtils genericConverterUtils) {
        this.articuloService = articuloService;
        this.genericConverterUtils = genericConverterUtils;
    }


    @Override
    public ResponseEntity<ArticuloDTO> createArticulo(ArticuloDTO articuloDTO) throws Exception {
        Articulo articuloResult = articuloService.save(genericConverterUtils.convertToEntity(articuloDTO, Articulo.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(articuloResult.getIdArticulo()).toUri();
        return ResponseEntity.created(location).body(genericConverterUtils.convertToDto(articuloResult, ArticuloDTO.class));
    }

    @Override
    public ResponseEntity<ArticuloDTO> updateArticulo(ArticuloDTO articuloDTO, Long id) throws Exception {
        Articulo articuloResult = articuloService.update(id, genericConverterUtils.convertToEntity(articuloDTO, Articulo.class));
        return ResponseEntity.ok(genericConverterUtils.convertToDto(articuloResult, ArticuloDTO.class));
    }

    @Override
    public ResponseEntity<ArticuloDTO> getArticulo(Long id) throws Exception {
        return ResponseEntity.ok(genericConverterUtils.convertToDto(articuloService.findById(id), ArticuloDTO.class));
    }

    @Override
    public ResponseEntity<List<ArticuloDTO>> getAllArticulo() throws Exception {
        return ResponseEntity.ok(genericConverterUtils.convertListToListDto(articuloService.findAll(), ArticuloDTO.class));
    }

    @Override
    public ResponseEntity<Void> deleteArticulo(Long id) throws Exception {
        articuloService.delete(id);
        return ResponseEntity.ok().build();
    }
}
