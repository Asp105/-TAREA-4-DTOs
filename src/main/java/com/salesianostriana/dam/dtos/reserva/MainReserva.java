package com.salesianostriana.dam.dtos.reserva;

import com.salesianostriana.dam.dtos.reserva.dto.ReservaDTO;
import com.salesianostriana.dam.dtos.reserva.model.Cliente;
import com.salesianostriana.dam.dtos.reserva.model.Habitacion;
import com.salesianostriana.dam.dtos.reserva.model.Reserva;

public class MainReserva {
    public static void main(String[] args) {
        Cliente c1 = Cliente.builder().id(1L).nombre("Laura").apellidos("García Pérez").build();
        Habitacion h1 = Habitacion.builder().id(1L).numero("204").tipo("Doble").precioNoche(75.0).build();

        // 1. Reserva completa
        Reserva r1 = Reserva.builder().id(1L).codigo("RES-101").numeroNoches(3).cliente(c1).habitacion(h1).build();

        // 2. Reserva sin cliente ni número de noches
        Reserva r2 = Reserva.builder().id(2L).codigo("RES-102").habitacion(h1).build();

        // 3. Reserva con habitación sin precioNoche
        Habitacion hSinPrecio = Habitacion.builder().id(2L).numero("101").tipo("Individual").build();
        Reserva r3 = Reserva.builder().id(3L).codigo("RES-103").numeroNoches(2).cliente(c1).habitacion(hSinPrecio).build();

        System.out.println(ReservaDTO.of(r1));
        System.out.println(ReservaDTO.of(r2));
        System.out.println(ReservaDTO.of(r3));
        System.out.println(ReservaDTO.of(null));
    }
}