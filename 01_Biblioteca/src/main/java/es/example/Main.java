package es.example;

import es.example.app.BibliotecaApp;
import es.example.exception.RecursoNoDisponibleException;
import es.example.model.Libro;
import es.example.model.Publicacion;
import es.example.model.Revista;
import es.example.service.PublicacionService;
import es.example.service.PublicacionServiceImpl;

import java.util.logging.*;

import java.util.ArrayList;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {


        Libro libro1 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes");
        Libro libro2 = new Libro("La Celestina", "Fernando de Rojas");


        Revista revista1 = new Revista("Time", "New York Times");
        Revista revista2 = new Revista("Rolling Stone", "Rolling Stone" );

        ArrayList<Publicacion> inventario = new ArrayList<>();


        inventario.add(libro1);
        inventario.add(libro2);

        inventario.add(revista1);
        inventario.add(revista2);


        PublicacionService service = new PublicacionServiceImpl(inventario);
        BibliotecaApp app = new BibliotecaApp(service);
        app.run();



    }

}