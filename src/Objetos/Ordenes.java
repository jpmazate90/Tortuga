
package Objetos;

import java.awt.Color;

public class Ordenes {
    private boolean lapicero;
    private Color color;
    private int posX;
    private int posY;

    public Ordenes( int posX, int posY, Color color,boolean lapicero) {
        this.lapicero = lapicero;
        this.color = color;
        this.posX = posX;
        this.posY = posY;
    }

    public boolean isLapicero() {
        return lapicero;
    }

    public void setLapicero(boolean lapicero) {
        this.lapicero = lapicero;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    
    
    
}
