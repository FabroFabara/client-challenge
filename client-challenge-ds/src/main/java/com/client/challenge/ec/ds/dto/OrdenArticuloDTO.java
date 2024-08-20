package com.client.challenge.ec.ds.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdenArticuloDTO {

    private Long idDetalle;

    private String idOrden;

    private Long idArticulo;

    private Integer cantidad;
}
