package com.salesianostriana.dam.dtos.reserva.dto;

import com.salesianostriana.dam.dtos.reserva.model.Cliente;
import com.salesianostriana.dam.dtos.reserva.model.Habitacion;
import com.salesianostriana.dam.dtos.reserva.model.Reserva;

public record ReservaDTO(
        String codigo,
        String cliente,
        String habitacion,
        Integer numeroNoches,
        Double precioTotal
) {
    public static ReservaDTO of(Reserva reserva) {
        if (reserva == null) {
            return null;
        }

        // 1. Nombre completo del cliente
        String nombreCliente = null;
        if (reserva.getCliente() != null) {
            Cliente c = reserva.getCliente();
            String texto = "";
            if (c.getNombre() != null) {
                texto += c.getNombre() + " ";
            }
            if (c.getApellidos() != null) {
                texto += c.getApellidos();
            }
            texto = texto.trim();
            if (!texto.isEmpty()) {
                nombreCliente = texto;
            }
        }

        // 2. Descripción de la habitación Doble
        String descHabitacion = null;
        Double precioNoche = null;

        if (reserva.getHabitacion() != null) {
            Habitacion h = reserva.getHabitacion();
            precioNoche = h.getPrecioNoche();

            String texto = "";
            if (h.getNumero() != null) {
                texto += h.getNumero();
            }
            if (h.getTipo() != null) {
                if (!texto.isEmpty()) {
                    texto += " - ";
                }
                texto += h.getTipo();
            }
            texto = texto.trim();
            if (!texto.isEmpty()) {
                descHabitacion = texto;
            }
        }

        // 3. Cálculo del precio total
        Double precioTotal = null;
        if (reserva.getNumeroNoches() != null && precioNoche != null) {
            precioTotal = reserva.getNumeroNoches() * precioNoche;
        }

        return new ReservaDTO(
                reserva.getCodigo(),
                nombreCliente,
                descHabitacion,
                reserva.getNumeroNoches(),
                precioTotal
        );
    }
}