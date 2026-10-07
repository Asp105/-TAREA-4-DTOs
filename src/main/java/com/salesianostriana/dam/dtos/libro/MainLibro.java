package com.salesianostriana.dam.dtos.libro;

import com.salesianostriana.dam.dtos.libro.dto.LibroDTO;
import com.salesianostriana.dam.dtos.libro.model.Autor;
import com.salesianostriana.dam.dtos.libro.model.Libro;

public class MainLibro {
    public static void main(String[] args) {


        Autor a1 = Autor.builder()
                .id(1L)
                .nombre("Miguel")
                .apellido1("de Cervantes")
                .apellido2("Saavedra")
                .nacionalidad("Española")
                .build();


        Autor a2 = Autor.builder()
                .id(2L)
                .nombre("George")
                .apellido1("Orwell")
                .build();

        Libro l1 = Libro.builder().id(1L).titulo("Don Quijote").isbn("1234").anioPublicacion(1605).autor(a1).build();
        Libro l2 = Libro.builder().id(2L).titulo("1984").isbn("5678").anioPublicacion(1949).autor(a2).build();
        Libro l3 = Libro.builder().id(3L).titulo("Libro Anónimo").isbn("9999").anioPublicacion(2020).autor(null).build();

        System.out.println(LibroDTO.of(l1));
        System.out.println(LibroDTO.of(l2));
        System.out.println(LibroDTO.of(l3)); // Libro sin autor
        System.out.println(LibroDTO.of(null));
    }
}