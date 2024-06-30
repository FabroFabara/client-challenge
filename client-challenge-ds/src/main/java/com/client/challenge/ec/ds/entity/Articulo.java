package com.client.challenge.ec.ds.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "articulo")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_articulo", unique = true, nullable = false)
    private Long idArticulo;

    @Column(name = "nombre_articulo")
    private String nombreArticulo;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden", referencedColumnName = "id_orden")
    private Orden orden;
}
