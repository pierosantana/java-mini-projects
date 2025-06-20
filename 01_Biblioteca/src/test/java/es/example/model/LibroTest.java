package es.example.model;

import es.example.exception.RecursoNoDisponibleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    private Publicacion libro;

    @BeforeEach
    void setUp() {
        libro = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes");
    }

    @Test
    @DisplayName("Prestar recurso cambia el estado a prestado")
    void prestarCambiaEstado() throws RecursoNoDisponibleException {

        assertFalse(libro.isPrestado(), "Debe empezar no prestado");
        libro.prestar();
        assertTrue(libro.isPrestado(), "Después de prestar debe estar prestado");
    }

    @Test
    @DisplayName("Prestar ya prestado lanza excepción")
    void prestarDuplicadoLanzaException() throws RecursoNoDisponibleException {
        libro.prestar();
        RecursoNoDisponibleException ex = assertThrows(
            RecursoNoDisponibleException.class,
            () -> libro.prestar()
        );
        assertEquals("El recurso no puede ser prestado.", ex.getMessage());
    }

    @Test
    @DisplayName("Devolver recurso cambia el estado a disponible")
    void devolverCambiaEstado() throws RecursoNoDisponibleException {
        libro.prestar();
        libro.devolver();
        assertFalse(libro.isPrestado(), "Después de devolver no debe estar prestado");
    }

    @Test
    @DisplayName("Devolver sin préstamo lanza excepción")
    void devolverSinPrestarLanzaException() throws RecursoNoDisponibleException {
        RecursoNoDisponibleException ex = assertThrows(
            RecursoNoDisponibleException.class,
            () -> libro.devolver(),
            "Mensaje que se muestra si el assert falla"
        );
        assertEquals("El recurso no puede ser devuelto.", ex.getMessage());
    }
}