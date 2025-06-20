package es.example.model;

import es.example.exception.RecursoNoDisponibleException;
import es.example.interfaces.Prestable;
import java.util.logging.Logger;

public abstract class Publicacion implements Prestable {
    private String titulo;
    private String autor;
    private boolean prestado;
    private static final Logger logger = Logger.getLogger(Publicacion.class.getName());

    public Publicacion(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void devolver() throws RecursoNoDisponibleException {

        if (this.prestado) {
            this.prestado = false;
        } else {
            throw new RecursoNoDisponibleException("El recurso no puede ser devuelto.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void prestar() throws RecursoNoDisponibleException {
        if (this.prestado){
            throw new RecursoNoDisponibleException("El recurso no puede ser prestado.");
        }else{
            this.prestado = true;
        }

    }
}
