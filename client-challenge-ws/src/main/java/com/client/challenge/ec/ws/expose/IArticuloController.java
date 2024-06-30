package com.client.challenge.ec.ws.expose;

import com.client.challenge.ec.ds.dto.ArticuloDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.client.challenge.ec.ws.common.SwaggerConstants.ARTICULO_DESCRIPTION;
import static com.client.challenge.ec.ws.common.SwaggerConstants.ARTICULO_TAG;

@Tag(name = ARTICULO_TAG, description = ARTICULO_DESCRIPTION)
@RequestMapping("/api/articulo")
public interface IArticuloController {

    @Operation(summary = "API para crear Articulo")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Articulo creado"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Articulo ya existe")
    })
    @PostMapping
    ResponseEntity<ArticuloDTO> createArticulo(@Valid @RequestBody ArticuloDTO articuloDTO) throws Exception;

    @Operation(summary = "API para actualizar Articulo")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Articulo actualizado"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Articulo no encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<ArticuloDTO> updateArticulo(@RequestBody ArticuloDTO articuloDTO, @PathVariable Long id) throws Exception;

    @Operation(summary = "API para obtener Articulos por id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Articulo encontrado"),
            @ApiResponse(responseCode = "404", description = "Articulo no encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<ArticuloDTO> getArticulo(@PathVariable Long id) throws Exception;

    @Operation(summary = "API para obtener todos los Articulos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Articulos encontrados"),
            @ApiResponse(responseCode = "404", description = "Articulos no encontrado")
    })
    @GetMapping
    ResponseEntity<List<ArticuloDTO>> getAllArticulo() throws Exception;

    @Operation(summary = "API para eliminar Articulo por id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Articulo eliminado"),
            @ApiResponse(responseCode = "404", description = "Articulo no encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteArticulo(@PathVariable Long id) throws Exception;

}
