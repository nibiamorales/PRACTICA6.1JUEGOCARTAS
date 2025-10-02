package com.mycompany.cartasjuego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Canvas {

    private static Canvas canvasSingleton;

    public static Canvas getCanvas() {
        if (canvasSingleton == null) {
            canvasSingleton = new Canvas("BlueJ Picture Demo", 500, 300, Color.white);
        }
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    private List<Object> objects;
    private HashMap<Object, ShapeDescription> shapes;
    private HashMap<Object, TextDescription> labels;

    private Canvas(String title, int width, int height, Color bgColor) {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        frame.setLocation(30, 30);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
        objects = new ArrayList<>();
        shapes = new HashMap<>();
        labels = new HashMap<>();
    }

    public void setVisible(boolean visible) {
        if (graphic == null) {
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D) canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

    public void draw(Object referenceObject, String color, Shape shape) {
        objects.remove(referenceObject);
        objects.add(referenceObject);
        shapes.put(referenceObject, new ShapeDescription(shape, color));
        redraw();
    }

    public void drawText(Object referenceObject, String color, String text, int x, int y) {
        objects.remove(referenceObject);
        objects.add(referenceObject);
        labels.put(referenceObject, new TextDescription(text, color, x, y));
        redraw();
    }

    public void erase(Object referenceObject) {
        objects.remove(referenceObject);
        shapes.remove(referenceObject);
        labels.remove(referenceObject);
        redraw();
    }

    public void setForegroundColor(String colorString) {
        if (colorString.equals("red")) {
            graphic.setColor(new Color(235, 25, 25));
        } else if (colorString.equals("black")) {
            graphic.setColor(Color.black);
        } else if (colorString.equals("blue")) {
            graphic.setColor(new Color(30, 75, 220));
        } else if (colorString.equals("yellow")) {
            graphic.setColor(new Color(255, 230, 0));
        } else if (colorString.equals("green")) {
            graphic.setColor(new Color(80, 160, 60));
        } else if (colorString.equals("magenta")) {
            graphic.setColor(Color.magenta);
        } else if (colorString.equals("white")) {
            graphic.setColor(Color.white);
        } else {
            graphic.setColor(Color.black);
        }
    }

    public void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception ignored) {}
    }

    private void redraw() {
        erase();
        for (Object key : objects) {
            ShapeDescription sd = shapes.get(key);
            if (sd != null) sd.draw(graphic);
            TextDescription td = labels.get(key);
            if (td != null) td.draw(graphic);
        }
        canvas.repaint();
    }

    private void erase() {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
    }

    private class CanvasPane extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(canvasImage, 0, 0, null);
        }
        private static final long serialVersionUID = 1L;
    }

    private class ShapeDescription {
        private Shape shape;
        private String colorString;
        public ShapeDescription(Shape shape, String color) {
            this.shape = shape;
            colorString = color;
        }
        public void draw(Graphics2D graphic) {
            setForegroundColor(colorString);
            graphic.fill(shape);
        }
    }

    private class TextDescription {
        private String text;
        private String colorString;
        private int x, y;
        public TextDescription(String text, String color, int x, int y) {
            this.text = text;
            this.colorString = color;
            this.x = x;
            this.y = y;
        }
        public void draw(Graphics2D graphic) {
            setForegroundColor(colorString);
            graphic.drawString(text, x, y);
        }
    }
}
