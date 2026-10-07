package com.salesianostriana.dam.dtos.serie.dto;

import com.salesianostriana.dam.dtos.serie.model.Creador;
import com.salesianostriana.dam.dtos.serie.model.Serie;

public record SerieDTO(
        String titulo,
        Integer temporadas,
        String creador,
        String categoria,
        String imagenPrincipal
) {
    public static SerieDTO of(Serie serie) {
        if (serie == null) {
            return null;
        }

        // 1. Nombre completo del creador
        String nombreCreador = null;
        if (serie.getCreador() != null) {
            Creador c = serie.getCreador();
            String texto = "";
            if (c.getNombre() != null) {
                texto += c.getNombre() + " ";
            }
            if (c.getApellidos() != null) {
                texto += c.getApellidos();
            }
            texto = texto.trim();
            if (!texto.isEmpty()) {
                nombreCreador = texto;
            }
        }

        // 2. Nombre de la categoría
        String nombreCategoria = null;
        if (serie.getCategoria() != null) {
            nombreCategoria = serie.getCategoria().getNombre();
        }

        // 3. Primera imagen de la lista de forma segura
        String imagenPrincipal = null;
        if (serie.getImagenes() != null && !serie.getImagenes().isEmpty()) {
            imagenPrincipal = serie.getImagenes().get(0);
        }

        return new SerieDTO(
                serie.getTitulo(),
                serie.getNumeroTemporadas(),
                nombreCreador,
                nombreCategoria,
                imagenPrincipal
        );
    }
}