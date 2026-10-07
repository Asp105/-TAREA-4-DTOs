package com.salesianostriana.dam.dtos.serie;

import com.salesianostriana.dam.dtos.serie.dto.SerieDTO;
import com.salesianostriana.dam.dtos.serie.model.Categoria;
import com.salesianostriana.dam.dtos.serie.model.Creador;
import com.salesianostriana.dam.dtos.serie.model.Serie;

import java.util.Collections;
import java.util.List;

public class MainSerie {
    public static void main(String[] args) {
        Creador creador = Creador.builder().id(1L).nombre("Vince").apellidos("Gilligan").build();
        Categoria cat = Categoria.builder().id(1L).nombre("Drama").build();

        // 1. Serie completa
        Serie s1 = Serie.builder()
                .id(1L).titulo("Breaking Bad").numeroTemporadas(5)
                .creador(creador).categoria(cat)
                .imagenes(List.of("img1.jpg", "img2.jpg"))
                .build();

        // 2. Serie sin categoría
        Serie s2 = Serie.builder()
                .id(2L).titulo("Stranger Things").numeroTemporadas(4)
                .creador(creador).categoria(null)
                .imagenes(List.of("st1.png"))
                .build();

        // 3. Serie sin imágenes (null)
        Serie s3 = Serie.builder()
                .id(3L).titulo("Dark").numeroTemporadas(3)
                .creador(creador).categoria(cat)
                .imagenes(null)
                .build();

        // 4. Serie con lista de imágenes vacía
        Serie s4 = Serie.builder()
                .id(4L).titulo("The Office").numeroTemporadas(9)
                .creador(creador).categoria(cat)
                .imagenes(Collections.emptyList())
                .build();

        System.out.println(SerieDTO.of(s1));
        System.out.println(SerieDTO.of(s2));
        System.out.println(SerieDTO.of(s3));
        System.out.println(SerieDTO.of(s4));
        System.out.println(SerieDTO.of(null)); // 5. Pasando null
    }
}