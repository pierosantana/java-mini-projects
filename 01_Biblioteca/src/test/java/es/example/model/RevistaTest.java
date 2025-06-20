package es.example.model;

import es.example.exception.RecursoNoDisponibleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RevistaTest {

    private Publicacion revista;

    @BeforeEach
    void setUp() {
        revista = new Revista("Rolling Stone", "New York Times");
    }

    @Test
    @DisplayName("Prestar recurso cambia el estado a prestado")
    void prestarCambiaEstado() throws RecursoNoDisponibleException {

        assertFalse(revista.isPrestado(), "Debe empezar no prestado");
        revista.prestar();
        assertTrue(revista.isPrestado(), "Después de prestar debe estar prestado");
    }

    @Test
    @DisplayName("Prestar ya prestado lanza excepción")
    void prestarDuplicadoLanzaException() throws RecursoNoDisponibleException {
        revista.prestar();
        RecursoNoDisponibleException ex = assertThrows(
            RecursoNoDisponibleException.class,
            () -> revista.prestar()
        );
        assertEquals("El recurso no puede ser prestado.", ex.getMessage());
    }

    @Test
    @DisplayName("Devolver recurso cambia el estado a disponible")
    void devolverCambiaEstado() throws RecursoNoDisponibleException {
        revista.prestar();
        revista.devolver();
        assertFalse(revista.isPrestado(), "Después de devolver no debe estar prestado");
    }

    @Test
    @DisplayName("Devolver sin préstamo lanza excepción")
    void devolverSinPrestarLanzaException() throws RecursoNoDisponibleException {
        RecursoNoDisponibleException ex = assertThrows(
            RecursoNoDisponibleException.class,
            () -> revista.devolver(),
            "Mensaje que se muestra si el assert falla"
        );
        assertEquals("El recurso no puede ser devuelto.", ex.getMessage());
    }
}