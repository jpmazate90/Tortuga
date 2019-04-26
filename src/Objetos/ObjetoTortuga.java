/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Logica.Acciones;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author jcsr
 */
public class ObjetoTortuga extends JPanel {

    private String color = "000000";
    private String colorActual = "000000";
    private boolean mostrar = true;
    private boolean lapicero = true;
    private ArrayList<Ordenes> ordenes = new ArrayList<>();
    private int posX1 = 400;
    private int posY1 = 200;
    private int posX0 = 400;
    private int posY0 = 200;
    private int grados = 90;

    public ObjetoTortuga() {
        this.setSize(965, 370);
        this.setBackground(Color.WHITE);

    }

    public void accionForward(int n) {
        double nn = n;
        double valorx = Math.cos(this.grados*Math.PI/180);
        double valory = Math.sin(this.grados*Math.PI/180);
        double y1 = nn*valory;
        double x1 = nn*valorx;
        int auxx = (int)x1;
        int auxy = (int)y1;
        posY1 = posY1 - auxy;
        posX1 = posX1 - auxx;
        this.ordenes.add(new Ordenes(posX1, posY1, obtenerObjetoColor(colorActual), lapicero));
        refrescar();
    }

    public void accionBackward(int n) {
        
        double nn = n;
        double valorx = Math.cos(this.grados*Math.PI/180);
        double valory = Math.sin(this.grados*Math.PI/180);
        double y1 = nn*valory;
        double x1 = nn*valorx;
        int auxx = (int)x1;
        int auxy = (int)y1;
        posY1 = posY1 + auxy;
        posX1 = posX1 + auxx;
        this.ordenes.add(new Ordenes(posX1, posY1, obtenerObjetoColor(colorActual), lapicero));

        refrescar();
    }

    public void accionRight(int n) {
        this.grados = this.grados+n;
       
    }

    public void accionLeft(int n) {
        this.grados = this.grados-n;
    }

    public void accionPenDown() {
        lapicero = true;
        refrescar();
    }

    public void accionPenUp() {
        lapicero = false;
        refrescar();
    }

    public void accionShowTurtle() {
        mostrar = true;
        refrescar();
    }

    public void accionHideTurtle() {
        mostrar = false;
        refrescar();
    }

    public void accionClears() {
        posX1 = posX0;
        posY1 = posY0;
        ordenes.clear();
        this.ordenes.add(new Ordenes(posX1, posY1, obtenerObjetoColor(colorActual), lapicero));
        refrescar();
    }

    public void accionToCenter() {
        posX1 = posX0;
        posY1 = posY0;
        this.ordenes.add(new Ordenes(posX1, posY1, obtenerObjetoColor(colorActual), false));
        refrescar();
    }

    public void accionToErase() {
        if(this.colorActual.equals("ffffff")){
            
        }else{
            this.color = this.colorActual;
        }
        
        this.colorActual = "ffffff";
        refrescar();
    }

    public void accionToDraw() {
        this.colorActual = this.color;
        refrescar();
    }

    public void accionColor(String color) {
        if (color.contains("#")) {
            String n = color.replace("#", "");
            colorActual = n;
        } else if (Integer.parseInt(color) >= 0 && Integer.parseInt(color) < 10) {
            colorActual = obtenerColor(Integer.parseInt(color));
        } else {
            Acciones.area.append("\nCOLOR: " + color + " NO ESTA ENTRE 0-9");
            Acciones.error = true;
        }
        refrescar();
    }

    public void accionPositionxy(int x, int y) {
        posX1 = x;
        posY1 = y;
        this.ordenes.add(new Ordenes(posX1, posY1, obtenerObjetoColor(colorActual), false));
        refrescar();
    }

    public void accionPositionx(int x) {
        posX1 = x;
        this.ordenes.add(new Ordenes(posX1, posY1, obtenerObjetoColor(colorActual), false));
        refrescar();
    }

    public void accionPositiony(int y) {
        posY1 = y;
        this.ordenes.add(new Ordenes(posX1, posY1, obtenerObjetoColor(colorActual), false));
        refrescar();
    }

    
    public void refrescar() {
        this.remove(this);
        this.validate();
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarTortuga(g);
        for (int i = 1; i < ordenes.size(); i++) {
            if (ordenes.get(i).isLapicero()) {
                g.setColor(ordenes.get(i).getColor());
                g.drawLine(ordenes.get(i - 1).getPosX(), ordenes.get(i - 1).getPosY(), ordenes.get(i).getPosX(), ordenes.get(i).getPosY());
            }
        }
    }

    public void dibujarTortuga(Graphics g) {
        if (mostrar) {
            g.setColor(obtenerObjetoColor("000000"));
            g.fillOval(posX1, posY1, 16, 16);//Hace el caparazon
            g.drawOval(posX1 - 3, posY1 - 1, 5, 5);//Hace pata izquierda adelante
            g.drawOval(posX1 - 3, posY1 + 10, 5, 5);//pata izq atras
            g.drawOval(posX1 + 14, posY1 - 1, 5, 5);//pata derecha adelante
            g.drawOval(posX1 + 15, posY1 + 10, 5, 5);//pata derecha atras
            g.drawOval(posX1 + 5, posY1 - 5, 6, 6);//cabeza
        }
    }
    
    public void repaint(int x, int y) {
        posX1 = x;
        posY1 = y;
        this.ordenes.add(new Ordenes(x, y, obtenerObjetoColor(colorActual), lapicero));
        this.refrescar();

    }

    
    public String obtenerColor(int numero) {
        String hexa = "";
        if(numero==0){//negro
            hexa = "000000";
        }else if(numero==1){//rojo
            hexa = "CB3234";
        }else if(numero==2){//anaranjado
             hexa = "FF8000";
        }else if(numero==3){//amarillo
             hexa = "FFFFE0";
        }else if(numero==4){//verde
             hexa = "008F39";
        }else if(numero==5){//celeste
             hexa = "2271B3";
        }else if(numero==6){//azul
             hexa = "3B83BD";
        }else if(numero==7){//morado
             hexa = "572364";
        }else if(numero==8){//rosado
             hexa = "FFB6C1";
        }else if(numero==9){//gris
             hexa = "808080";
        }else{
            hexa = "ffffff";
        }
       
        return hexa;

    }

    public Color obtenerObjetoColor(String colorStr) {

        return new Color(
                Integer.valueOf(colorStr.substring(0, 2), 16),
                Integer.valueOf(colorStr.substring(2, 4), 16),
                Integer.valueOf(colorStr.substring(4, 6), 16));
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorActual() {
        return colorActual;
    }

    public void setColorActual(String colorActual) {
        this.colorActual = colorActual;
    }

    public int getGrados() {
        return grados;
    }

    public void setGrados(int grados) {
        this.grados = grados;
    }

    
    
}
