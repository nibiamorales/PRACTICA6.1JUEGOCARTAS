package com.mycompany.cartasjuego;

import java.awt.geom.RoundRectangle2D;

public final class Visualizador {

    private static final int CARD_W = 80;
    private static final int CARD_H = 120;
    private static final int CARD_ARC = 18;

    private Visualizador() {}

    public static void carta(Carta c, Posicion p) {
        Canvas cv = Canvas.getCanvas();

        cv.draw(ref(c, p, "borde"), "black",
                new RoundRectangle2D.Double(p.getX() - 1, p.getY() - 1, CARD_W + 2, CARD_H + 2, CARD_ARC, CARD_ARC));

        cv.draw(ref(c, p, "cuerpo"), "white",
                new RoundRectangle2D.Double(p.getX(), p.getY(), CARD_W, CARD_H, CARD_ARC, CARD_ARC));

        String etiqueta = c.getValorTexto() + " " + c.getFigura().getSimbolo();
        String colorTexto = switch (c.getFigura()) {
            case CORAZONES, DIAMANTES -> "red";
            default -> "black";
        };

        cv.drawText(ref(c, p, "label-tl"), colorTexto, etiqueta, p.getX() + 10, p.getY() + 20);
        cv.drawText(ref(c, p, "label-center"), colorTexto,
                String.valueOf(c.getFigura().getSimbolo()),
                p.getX() + (CARD_W / 2) - 5, p.getY() + (CARD_H / 2) + 5);
    }

    private static Object ref(Carta c, Posicion p, String parte) {
        return "CARD@" + p.getX() + "," + p.getY() + ":" + c.getValorTexto() + c.getFigura() + ":" + parte;
        }
}
