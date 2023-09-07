package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import copControl.Posicion;

public class PosiciónTest {

    Posicion posicion;
    Posicion posicion2;
    Posicion posicion3;
    Posicion posicion4;
    Posicion posicion5;
    Posicion derecha;
    Posicion abajo;
    Posicion izquierda;
    Posicion arriba;
    Posicion arribaDerecha;
    Posicion abajoDerecha;
    Posicion abajoIzquierda;
    Posicion arribaIzquierda;

    @Before
    public void setUp() {
        // creamos la poscion y sus posiciones vecinas
        posicion = new Posicion(5, 5);

        derecha = new Posicion(6, 5);
        abajo = new Posicion(5, 6);
        izquierda = new Posicion(4, 5);
        arriba = new Posicion(5, 4);
        arribaDerecha = new Posicion(6, 4);
        abajoDerecha = new Posicion(6, 6);
        abajoIzquierda = new Posicion(4, 6);
        arribaIzquierda = new Posicion(4, 4);

        // asignamos a la posicion2 una coordenada que se encuentra hacia abajo a la
        // derecha de la posicion1
        posicion2 = new Posicion(9, 8);

        // la tres hacia la izquerda
        posicion3 = new Posicion(2, 5);

        // la 4 hacia abajo
        posicion4 = new Posicion(5, 14);

        // la 5 hacia arriba a la derecha
        posicion5 = new Posicion(15, 4);

    }

    @Test
    public void testPosiciones() {

        // testeamos que el metodo nos devuelva la posicion vecina dereccionada
        // correctamente hacia la posicion objetivo

        // buscamos que intente ir hacia abajo a la derecha con la posicion2
        assertTrue(abajoDerecha.igualA(posicion.getVecinoDeDistanciaMinima(posicion2)));

        // buscamos que intente ir hacia la izquierda con la posicion3
        assertTrue(izquierda.igualA(posicion.getVecinoDeDistanciaMinima(posicion3)));

        // buscamos que intente ir hacia abajo con la posicion4
        assertTrue(abajo.igualA(posicion.getVecinoDeDistanciaMinima(posicion4)));

        // buscamos que intente ir hacia arriba a la derecha con la posicion5
        assertTrue(arribaDerecha.igualA(posicion.getVecinoDeDistanciaMinima(posicion5)));
    }

}
