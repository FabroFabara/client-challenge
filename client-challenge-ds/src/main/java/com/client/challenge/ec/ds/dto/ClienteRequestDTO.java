package com.client.challenge.ec.ds.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDTO {

    private Long idCliente;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 3, max = 100, message = "El apellido debe tener entre 3 y 100 caracteres")
    private String apellido;
}
