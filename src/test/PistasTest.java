package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;
import copControl.Mapa;
import copControl.Posicion;
import pista.Helipuerto;
import pista.PistaDoble;

public class PistasTest {
    AvionSimple unAvionSimple;
    AvionPesado unAvionPesado;
    Helicoptero unHelicoptero;
    AvionComputarizado unAvionComputarizado;
    Posicion posicionPista1;
    Posicion posicionPista2;

    @Before
    public void setUp() throws Exception {
        Mapa mapaMovimiento = new Mapa();
        // Defino la posicion de los aviones
        Posicion posicionAviones = new Posicion(5, 10);

        // Genero los aviones
        unAvionSimple = new AvionSimple(posicionAviones, posicionAviones, mapaMovimiento);
        unAvionPesado = new AvionPesado(posicionAviones, posicionAviones, mapaMovimiento);
        unHelicoptero = new Helicoptero(posicionAviones, posicionAviones, mapaMovimiento);
        unAvionComputarizado = new AvionComputarizado(posicionAviones, mapaMovimiento);

        // genero las posiciones de las pistas
        posicionPista1 = new Posicion(5, 11);
        posicionPista2 = new Posicion(25, 26);
    }


    // *****TEST 1******
    @Test
    public void testPistaDoble() {

        try {
            // genero dos pistas dobles con diferentes posiciones
            PistaDoble pistaDoble1 = new PistaDoble(posicionPista1);
            PistaDoble pistaDoble2 = new PistaDoble(posicionPista2);

            // Asserts
            // Testeamos que en una pista doble pueden aterrizar aviones simples o
            // computarizados pero no
            // pueden aterrizar ni aviones pesados ni helicopteros
            assertTrue(pistaDoble1.puedeAterrizar(unAvionSimple));
            assertFalse(pistaDoble1.puedeAterrizar(unAvionPesado));
            assertFalse(pistaDoble1.puedeAterrizar(unHelicoptero));
            assertTrue(pistaDoble1.puedeAterrizar(unAvionComputarizado));

            // comprobamos que el avion puede aterrizar en la pistaDoble1 pero está muy
            // lejos de la pistaDoble2
            assertTrue(pistaDoble1.estaEnZonaAterrizaje(unAvionSimple));
            assertFalse(pistaDoble2.estaEnZonaAterrizaje(unAvionSimple));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // *****TEST 2******
    @Test
    public void testHelipuerto() {
        try {
            // genero dos pistas dobles con diferentes posiciones
            Helipuerto helipuerto1 = new Helipuerto(posicionPista1);
            Helipuerto helipuerto2 = new Helipuerto(posicionPista2);

            // Asserts
            // Testeamos que en un helipuerto solo pueden aterrizar los helicopteros
            assertFalse(helipuerto1.puedeAterrizar(unAvionSimple));
            assertFalse(helipuerto1.puedeAterrizar(unAvionPesado));
            assertTrue(helipuerto1.puedeAterrizar(unHelicoptero));
            assertFalse(helipuerto1.puedeAterrizar(unAvionComputarizado));

            // comprobamos que el helicopterio puede aterrizar en la helipuerto1 pero está
            // muy lejos de la helipuerto2
            assertTrue(helipuerto1.estaEnZonaAterrizaje(unAvionSimple));
            assertFalse(helipuerto2.estaEnZonaAterrizaje(unAvionSimple));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
