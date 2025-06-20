package es.example.service;

import es.example.exception.RecursoNoDisponibleException;
import es.example.model.Libro;
import es.example.model.Publicacion;
import es.example.model.Revista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PublicacionServiceImplTest {
    private List<Publicacion> inventario;
    private PublicacionServiceImpl service;

    @BeforeEach
    void setUp(){
        inventario = new ArrayList<>();
        inventario.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes"));
        inventario.add(new Revista("La Celestina", "Fernando de Rojas"));
        service = new PublicacionServiceImpl(inventario);

    }

    @Test
    @DisplayName("Lista de publicaciones correcta")
    void listaPublicaciones(){
        List<Publicacion> lista = service.listaPublicaciones();
        assertEquals(2, lista.size(),"El inventario debe tener 2 elementos");
    }

    @Test
    @DisplayName("Prestar recurso cambia el estado a prestado")
    void prestarRecurso() throws RecursoNoDisponibleException {
            inventario.get(0).prestar();
        assertTrue(inventario.get(0).isPrestado(),"El primer elemento debe estar prestado");

    }

    @Test
    @DisplayName("Devolver recurso cambia el estado a disponible")
    void devolverRecurso() throws RecursoNoDisponibleException {
        inventario.get(0).prestar();
        inventario.get(0).devolver();
        assertFalse(inventario.get(0).isPrestado(),"El primer elemento debe estar disponible");

    }

    @Test
    @DisplayName("Devolver sin préstamo lanza excepción")
    void devolverSinPrestarLanzaException() {
        RecursoNoDisponibleException ex = assertThrows(
                RecursoNoDisponibleException.class,
                () -> inventario.get(inventario.size() - 1).devolver()
        );
        assertEquals("El recurso no puede ser devuelto.", ex.getMessage());
    }

    @Test
    @DisplayName("Prestar ya prestado lanza excepción")
    void prestarDuplicadoLanzaException() throws RecursoNoDisponibleException {
        inventario.get(inventario.size() - 1).prestar();
        RecursoNoDisponibleException ex = assertThrows(
                RecursoNoDisponibleException.class,
                () -> inventario.get(inventario.size() - 1).prestar()
        );
        assertEquals("El recurso no puede ser prestado.", ex.getMessage());
    }











}
