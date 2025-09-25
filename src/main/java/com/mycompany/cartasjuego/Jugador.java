package com.mycompany.cartasjuego;

import java.util.ArrayList;

/**
 *
 * @author Nibi2
 */
public class Jugador {
    public String nombre;
    private ArrayList<Carta> mano;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        this.mano =new ArrayList<>();
    }
    
    public void recibirCarta(Carta carta){
        mano.add(carta);
    }
    
    public Carta soltarCarta(int indice){
        return mano.remove(indice);
    }
    
    public ArrayList<Carta> getMano(){
        return mano;
    }
    
    public String toString() {
    return "Jugador " + nombre + " - Mano: " + mano;
}
}
