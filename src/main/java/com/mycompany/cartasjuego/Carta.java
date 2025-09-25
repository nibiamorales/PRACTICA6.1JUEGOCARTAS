package com.mycompany.cartasjuego;

/**
 *
 * @author Nibi2
 */
public class Carta {
    private int valor; // valores de 2 a 14
    private Figura figura;

public Carta(int valor, Figura figura){
    this.valor = valor;
    this.figura = figura;
    }

public int getValor(){
    return valor;
}

public Figura getFigura(){
    return figura;
}

public String getValorTexto(){
    if (valor == 11) 
        return "J";
    if (valor == 12)
        return "Q";
    if (valor == 13)
        return "K";
    if (valor == 14)
        return "A";
    return String.valueOf(valor);
}

public String toString(){
    return getValorTexto() + " de " + figura;
}

}