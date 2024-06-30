package com.client.challenge.ec.ds.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long idCliente;
    private String nombre;
    private String apellido;
    private List<OrdenDTO> ordenes;
}
