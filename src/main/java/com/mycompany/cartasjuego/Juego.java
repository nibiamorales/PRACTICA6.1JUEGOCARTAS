package com.mycompany.cartasjuego;

public class Juego {
    public static void main(String[] args) {
        System.out.println("Iniciando juego...");

        Mazo mazo = new Mazo();
        System.out.println("Cartas en el mazo al inicio: " + mazo.cartasDisponibles());

        mazo.barajear();
        System.out.println("Mazo barajeado.");

        Jugador j1 = new Jugador("Ana");
        Jugador j2 = new Jugador("Cesar");

        java.util.List<Jugador> jugadores = java.util.Arrays.asList(j1, j2);

        // reparte 5 por jugador en rondas
        mazo.repartir(jugadores, 5);

        System.out.println(j1);
        System.out.println(j2);
        System.out.println("Cartas restantes en el mazo: " + mazo.cartasDisponibles());

    }
}
