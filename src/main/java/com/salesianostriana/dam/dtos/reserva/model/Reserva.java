package com.salesianostriana.dam.dtos.reserva.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {
    private Long id;
    private String codigo;
    private Integer numeroNoches;
    private Cliente cliente;
    private Habitacion habitacion;
}