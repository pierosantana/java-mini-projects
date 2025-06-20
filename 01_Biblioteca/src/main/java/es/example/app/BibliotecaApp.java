package es.example.app;
import es.example.exception.RecursoNoDisponibleException;
import es.example.model.Publicacion;
import es.example.service.PublicacionService;

import java.util.List;
import java.util.logging.Logger;
public class BibliotecaApp {
    private static final Logger logger = Logger.getLogger(BibliotecaApp.class.getName());
    private final PublicacionService service;

    public BibliotecaApp(PublicacionService service) {
        this.service = service;
    }

    public void run(){
        logger.info("Iniciando BibliotecaApp");

        // Prestar
        Publicacion primero = service.listaPublicaciones().getFirst();
        try{
            service.prestar(primero);
            logger.info("El recurso " + primero.getTitulo() + " ha sido prestado.");
        }catch (RecursoNoDisponibleException e){
            logger.severe(e.getMessage());
        }

        //Devolver
        Publicacion ultimo = service.listaPublicaciones().getLast();
        try{
            service.devolver(ultimo);
            logger.info("El recurso " + ultimo.getTitulo() + " ha sido devuelto.");
        }catch (RecursoNoDisponibleException e){
            logger.severe(e.getMessage());
        }

        //Mostrar inventario
       mostrarInventario(service.listaPublicaciones());

    }

    private void mostrarInventario(List<Publicacion> inventario){
        for(Publicacion p: inventario){
            System.out.println(p.getTitulo() + " - " + p.getAutor() + " - " + p.isPrestado());
        }
    }
}
