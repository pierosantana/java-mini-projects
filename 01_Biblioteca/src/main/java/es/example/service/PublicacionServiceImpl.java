package es.example.service;

import es.example.exception.RecursoNoDisponibleException;
import es.example.model.Publicacion;

import java.util.List;

public class PublicacionServiceImpl implements PublicacionService{
    private final List<Publicacion> inventario;

public PublicacionServiceImpl(List<Publicacion> inventario){
    this.inventario = inventario;
}

    @Override
    public List<Publicacion> listaPublicaciones() {
        return inventario;
    }

    @Override
    public void prestar(Publicacion publicacion) throws RecursoNoDisponibleException {
    publicacion.prestar();

    }

    @Override
    public void devolver(Publicacion publicacion) throws RecursoNoDisponibleException {
    publicacion.devolver();
    }
}
