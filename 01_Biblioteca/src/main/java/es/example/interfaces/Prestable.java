package es.example.interfaces;

import es.example.exception.RecursoNoDisponibleException;

public interface Prestable {
    /**
     * Marca al recurso como prestado. Si el recurso ya está prestado,
     * se lanza la excepción RecursoNoDisponibleException.
     *
     * @throws RecursoNoDisponibleException Si el recurso no puede ser prestado
     *          porque ya tiene el estado de prestado.
     */
    public void prestar() throws RecursoNoDisponibleException;

    /**
     * Marca un recurso como disponible. Si el recurso no está prestado, lanza
     * una excepción indicando que no es posible realizar la devolución.
     *
     * @throws RecursoNoDisponibleException Si el recurso no puede ser devuelto
     *         porque no está en estado de prestado.
     */
    public void devolver() throws RecursoNoDisponibleException;
}
