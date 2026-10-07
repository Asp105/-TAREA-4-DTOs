package com.salesianostriana.dam.dtos.libro.dto;

import com.salesianostriana.dam.dtos.libro.model.Autor;
import com.salesianostriana.dam.dtos.libro.model.Libro;

public record LibroDTO(
        String titulo,
        String isbn,
        String autor,
        Integer anioPublicacion
) {
    public static LibroDTO of(Libro libro) {
        if (libro == null) {
            return null;
        }

        String nombreAutor = null;

        if (libro.getAutor() != null) {
            Autor a = libro.getAutor();
            String texto = "";

            if (a.getNombre() != null) {
                texto += a.getNombre() + " ";
            }
            if (a.getApellido1() != null) {
                texto += a.getApellido1() + " ";
            }
            if (a.getApellido2() != null) {
                texto += a.getApellido2();
            }

            texto = texto.trim();

            if (!texto.isEmpty()) {
                nombreAutor = texto;
            }
        }

        return new LibroDTO(
                libro.getTitulo(),
                libro.getIsbn(),
                nombreAutor,
                libro.getAnioPublicacion()
        );
    }
}