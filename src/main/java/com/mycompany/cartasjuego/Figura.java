/*
 * Clase Enum. FiGURA
Es un tipo especial de clase que define un conjunto fijo de valores a la vez */
package com.mycompany.cartasjuego;

/**
 *
 * @author Nibi2
 */
public enum Figura {
  
    CORAZONES('♥'), DIAMANTES('♦'), TREBOLES('♣'), PICAS('♠');
    private char simbolo;
    Figura(char simbolo) { this.simbolo = simbolo; }
    public char getSimbolo() { return simbolo; }

  
    
}
