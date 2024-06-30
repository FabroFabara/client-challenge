package com.client.challenge.ec.ws.expose;

import com.client.challenge.ec.ds.dto.ClienteDTO;
import com.client.challenge.ec.ds.dto.ClienteRequestDTO;
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

import static com.client.challenge.ec.ws.common.SwaggerConstants.CLIENTE_DESCRIPTION;
import static com.client.challenge.ec.ws.common.SwaggerConstants.CLIENTE_TAG;

@Tag(name = CLIENTE_TAG, description = CLIENTE_DESCRIPTION)
@RequestMapping("/api/cliente")
public interface IClienteController {

    @Operation(summary = "API para crear Cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente creado"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Cliente ya existe")
    })
    @PostMapping
    ResponseEntity<ClienteRequestDTO> createClient(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) throws Exception;

    @Operation(summary = "API para actualizar Cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente actualizado"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<ClienteRequestDTO> updateClient(@RequestBody ClienteRequestDTO clienteRequestDTO, @PathVariable Long id) throws Exception;

    @Operation(summary = "API para obtener Clientes por id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<ClienteDTO> getClient(@PathVariable Long id) throws Exception;

    @Operation(summary = "API para obtener todos los Clientes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Clientes encontrados"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @GetMapping
    ResponseEntity<List<ClienteDTO>> getAllClients() throws Exception;

    @Operation(summary = "API para eliminar cliente por id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Cleinte eliminado"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteClient(@PathVariable Long id) throws Exception;

}