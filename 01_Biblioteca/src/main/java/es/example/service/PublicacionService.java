package es.example.service;

import es.example.exception.RecursoNoDisponibleException;
import es.example.model.Publicacion;

import java.util.List;

public interface PublicacionService {
    List<Publicacion> listaPublicaciones();
    void prestar(Publicacion publicacion) throws RecursoNoDisponibleException;
    void devolver(Publicacion publicacion) throws RecursoNoDisponibleException;


}
