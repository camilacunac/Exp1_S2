package com.example.peliculas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PeliculaController {

    private List<Pelicula> peliculas = new ArrayList<>();

    // Constructor para crear algunas películas de muestra
    public PeliculaController() {
        peliculas.add(new Pelicula(1, "El Laberinto del Fauno", 2006, "Guillermo del Toro", "Fantasía",
                "Sinopsis de El Laberinto del Fauno"));
        peliculas.add(new Pelicula(2, "Amores Perros", 2000, "Alejandro González Iñárritu", "Drama",
                "Sinopsis de Amores Perros"));
        peliculas
                .add(new Pelicula(3, "Nueve Reinas", 2000, "Fabián Bielinsky", "Thriller", "Sinopsis de Nueve Reinas"));
        peliculas.add(new Pelicula(4, "Relatos Salvajes", 2014, "Damián Szifrón", "Comedia negra",
                "Sinopsis de Relatos Salvajes"));
        peliculas.add(new Pelicula(5, "El secreto de sus ojos", 2009, "Juan José Campanella", "Misterio",
                "Sinopsis de El secreto de sus ojos"));
    }

    // Obtener todas las películas
    @GetMapping("/peliculas")
    public List<Pelicula> getAllPeliculas() {
        return peliculas;
    }

    // Obtener una película por su ID
    @GetMapping("/peliculas/{id}")
    public Pelicula getPeliculaById(@PathVariable int id) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId() == id) {
                return pelicula;
            }
        }
        return null; // Si no se encuentra la película con el ID especificado
    }
}
