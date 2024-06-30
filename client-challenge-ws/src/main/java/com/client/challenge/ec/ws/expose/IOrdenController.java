package com.client.challenge.ec.ws.expose;

import com.client.challenge.ec.ds.dto.OrdenDTO;
import com.client.challenge.ec.ds.dto.OrdenRequestDTO;
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

import static com.client.challenge.ec.ws.common.SwaggerConstants.ORDEN_DESCRIPTION;
import static com.client.challenge.ec.ws.common.SwaggerConstants.ORDEN_TAG;

@Tag(name = ORDEN_TAG, description = ORDEN_DESCRIPTION)
@RequestMapping("/api/orden")
public interface IOrdenController {

    @Operation(summary = "API para crear Orden")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Orden creado"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Orden ya existe")
    })
    @PostMapping
    ResponseEntity<OrdenDTO> createOrder(@Valid @RequestBody OrdenRequestDTO ordenRequestDTO) throws Exception;

    @Operation(summary = "API para actualizar Orden")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Orden actualizado"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Orden no encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<OrdenDTO> updateOrder(@RequestBody OrdenDTO ordenDTO, @PathVariable String id) throws Exception;

    @Operation(summary = "API para obtener Ordenes por id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Orden encontrado"),
            @ApiResponse(responseCode = "404", description = "Orden no encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<OrdenDTO> getOrder(@PathVariable String id) throws Exception;

    @Operation(summary = "API para obtener todos los Ordenes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ordenes encontrados"),
            @ApiResponse(responseCode = "404", description = "Ordenes no encontrado")
    })
    @GetMapping
    ResponseEntity<List<OrdenDTO>> getAllOrder() throws Exception;

    @Operation(summary = "API para eliminar Orden por id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Orden eliminado"),
            @ApiResponse(responseCode = "404", description = "Orden no encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteOrder(@PathVariable String id) throws Exception;

}
