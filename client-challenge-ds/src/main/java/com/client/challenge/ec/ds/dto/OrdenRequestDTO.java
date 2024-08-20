package com.client.challenge.ec.ds.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdenRequestDTO {

    private String idOrden;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @FutureOrPresent(message = "La fecha no debe ser menor a la fecha actual")
    private LocalDateTime fecha;

    private ClienteRequestDTO cliente;

    private Integer cantidad;

    private List<ArticuloDTO> articulos;
}
