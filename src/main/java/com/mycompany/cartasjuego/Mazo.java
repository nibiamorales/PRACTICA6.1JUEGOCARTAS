package com.mycompany.cartasjuego;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Nibi2
 */
public class Mazo {
    private ArrayList<Carta> cartas;
    
    public Mazo(){
        cartas = new ArrayList<>();
        for (Figura f : Figura.values()){
            for (int v =2 ; v <=14  ; v++){
                cartas.add(new Carta (v,f));
            }
        }
    }
    
    public void repartir(java.util.List<Jugador> jugadores, int cartasPorJugador) {
    for (int r = 0; r < cartasPorJugador; r++) {
        for (Jugador j : jugadores) {
            Carta c = repartirUna();
            if (c != null) j.recibirCarta(c);
        }
    }
}

    public void barajear(){
        Collections.shuffle(cartas);
    }
    
    public Carta repartirUna(){
        if(!cartas.isEmpty()){
            return cartas.remove(0);
        }
        return null;
    }
    
    public int cartasDisponibles(){
        return cartas.size();
    }
    
    private java.util.Deque<Carta> noRepartidas = new java.util.ArrayDeque<>();
public void agregarNoRepartida(Carta c){ noRepartidas.push(c); }
public void regresarNoRepartidasAlMazo(){
    while(!noRepartidas.isEmpty()) cartas.add(noRepartidas.pop());
    java.util.Collections.shuffle(cartas);
}

}
