package com.client.challenge.ec.ds.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloDTO {

    private Long idArticulo;
    private String nombreArticulo;
    private double precioUnitario;
}
