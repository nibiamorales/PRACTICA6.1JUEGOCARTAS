package com.mycompany.cartasjuego;

public class DemoVisual {
    public static void main(String[] args) {
        Carta c1 = new Carta(14, Figura.CORAZONES); // A♥
        Carta c2 = new Carta(13, Figura.TREBOLES);  // K♣
        Carta c3 = new Carta(10, Figura.DIAMANTES); // 10♦

        Visualizador.carta(c1, new Posicion(40, 40));
        Visualizador.carta(c2, new Posicion(140, 40));
        Visualizador.carta(c3, new Posicion(240, 40));
    }
}
