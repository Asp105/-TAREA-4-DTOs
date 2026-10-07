package com.salesianostriana.dam.dtos.reserva.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Habitacion {
    private Long id;
    private String numero;
    private String tipo;
    private Double precioNoche;
    private Integer planta;
}