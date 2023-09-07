package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import avion.AvionSimple;
import copControl.Dificultad;
import copControl.Mapa;
import copControl.Nivel;
import copControl.Posicion;
import pista.Pista;
import pista.PistaSimple;

public class NivelTest {

    Mapa mapa1;
    Mapa mapa2;
    Dificultad dificultad;

    @Before
    public void setUp() throws Exception {
        //Creamos posiciones para los aviones y las pistas
        Posicion pos1 = new Posicion(1, 1);
        Posicion pos2 = new Posicion(20, 20);
        Posicion pos3 = new Posicion(5, 40);
        Posicion pos4 = new Posicion(50, 10);
        Posicion pos5 = new Posicion(30, 60);
        Posicion pos6 = new Posicion(60, 60);
        Posicion pos7 = new Posicion(90, 10);
        Posicion pos8 = new Posicion(0, 73);

        //generamos los aviones, 1 y 6 tienen la misma posicion
        AvionSimple avion1 = new AvionSimple(pos1, pos1, mapa1);
        AvionSimple avion2 = new AvionSimple(pos2, pos2, mapa1);
        AvionSimple avion3 = new AvionSimple(pos3, pos3, mapa1);
        AvionSimple avion4 = new AvionSimple(pos4, pos4, mapa1);
        AvionSimple avion5 = new AvionSimple(pos5, pos5, mapa1);
        AvionSimple avion6 = new AvionSimple(pos1, pos1, mapa1);

        //generamos las pistas, las pistas 4 y 5 tienen la misma posicion que los aviones 4 y 5
        PistaSimple pista1 = new PistaSimple(pos6);
        PistaSimple pista2 = new PistaSimple(pos7);
        PistaSimple pista3 = new PistaSimple(pos8);
        PistaSimple pista4 = new PistaSimple(pos4);
        PistaSimple pista5 = new PistaSimple(pos5);
        List<Pista> pistas = new ArrayList<>();
        pistas.add(pista1);
        pistas.add(pista2);
        pistas.add(pista3);
        pistas.add(pista4);
        pistas.add(pista5);

        //generamos dos mapas les agrgamos las pistas y los aviones
        mapa1 = new Mapa(pistas);
        mapa2 = new Mapa(pistas);

        //al mapa1 se le agregan los aviones con la misma posicion, en cambio al mapa2 no
        mapa1.colocarAvionEnAire(avion1);
        mapa1.colocarAvionEnAire(avion2);
        mapa1.colocarAvionEnAire(avion3);
        mapa1.colocarAvionEnAire(avion4);
        mapa1.colocarAvionEnAire(avion5);
        mapa1.colocarAvionEnAire(avion6);

        mapa2.colocarAvionEnAire(avion1);
        mapa2.colocarAvionEnAire(avion2);
        mapa2.colocarAvionEnAire(avion3);
        mapa2.colocarAvionEnAire(avion4);
        mapa2.colocarAvionEnAire(avion5);

        //creamos la dificultad
        dificultad = new Dificultad(5, 5, 5);
    }


    // *****TEST 3*******
    @Test
    public void TestColisiones() {

        //creamos dos niveles, nivel1 con los aviones con la posicion superpuesta y nivel2 sin
        Nivel nivel1 = new Nivel(mapa1, dificultad);
        Nivel nivel2 = new Nivel(mapa2, dificultad);

        //verificamos que en el nivel 1 haya un choque y en el nivel 2 no
        assertTrue(nivel1.huboChoque());
        assertFalse(nivel2.huboChoque());
    }

    // *****TEST 4*******
    @Test
    public void TestAterrizajes() {

        //creamos un nivel
        Nivel nivel = new Nivel(mapa1, dificultad);

        //verificamos que en el nivel atterizan los dos avienes con posicion que coincide con pistas
        assertEquals(2, nivel.aterrizarAviones());
    }
}
