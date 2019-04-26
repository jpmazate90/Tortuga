
package Objetos;

public class Instruccion {
    private String valor;
    private boolean esForward;
    private boolean esBackward;
    private boolean esRight;
    private boolean esLeft;
    private boolean esClears;
    private boolean esPenup;
    private boolean esPenDown;
    private boolean esToCenter;
    private boolean esColor;
    private boolean esPositionXY;
    private boolean esPositionX;
    private boolean esPositionY;
    private boolean esHideTurtle;
    private boolean esShowTurtle;
    private boolean esToErase;
    private boolean esToDraw;
    private boolean esRepeatInicio;
    private boolean esRepeatFin;

    public Instruccion(String instruccion,String valor) {
        this.valor = valor;
        if(instruccion.equals("fd")){
            esForward = true;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
        }else if(instruccion.equals("bk")){
            esForward = false;
            esBackward = true;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
        }else if(instruccion.equals("rt")){
            esForward = false;
            esBackward = false;
            esRight = true;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
            
        }else if(instruccion.equals("lt")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = true;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
            
        }else if(instruccion.equals("cs")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= true;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
            
        }else if(instruccion.equals("pu")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= true;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
            
        }else if(instruccion.equals("pd")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= true;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
            
        }else if(instruccion.equals("cr")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = true;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
            
        }else if(instruccion.equals("color")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = true;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
            
        }else if(instruccion.equals("posxy")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = true;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
            
        }else if(instruccion.equals("posx")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = true;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
            
        }else if(instruccion.equals("posy")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= true;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
            
        }else if(instruccion.equals("ht")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= true;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
        }else if(instruccion.equals("st")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= true;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
            
        }else if(instruccion.equals("te")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= true;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= false;
            
        }else if(instruccion.equals("td")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= true;
            esRepeatInicio= false;
            esRepeatFin= false;
            
        }else if(instruccion.equals("repeatInicio")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= true;
            esRepeatFin= false;
            
        }else if(instruccion.equals("repeatFIn")){
            esForward = false;
            esBackward = false;
            esRight = false;
            esLeft = false;
            esClears= false;
            esPenup= false;
            esPenDown= false;
            esToCenter = false;
            esColor = false;
            esPositionXY = false;
            esPositionX = false;
            esPositionY= false;
            esHideTurtle= false;
            esShowTurtle= false;
            esToErase= false;
            esToDraw= false;
            esRepeatInicio= false;
            esRepeatFin= true;
        }
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean isEsForward() {
        return esForward;
    }

    public void setEsForward(boolean esForward) {
        this.esForward = esForward;
    }

    public boolean isEsBackward() {
        return esBackward;
    }

    public void setEsBackward(boolean esBackward) {
        this.esBackward = esBackward;
    }

    public boolean isEsRight() {
        return esRight;
    }

    public void setEsRight(boolean esRight) {
        this.esRight = esRight;
    }

    public boolean isEsLeft() {
        return esLeft;
    }

    public void setEsLeft(boolean esLeft) {
        this.esLeft = esLeft;
    }

    public boolean isEsClears() {
        return esClears;
    }

    public void setEsClears(boolean esClears) {
        this.esClears = esClears;
    }

    public boolean isEsPenup() {
        return esPenup;
    }

    public void setEsPenup(boolean esPenup) {
        this.esPenup = esPenup;
    }

    public boolean isEsPenDown() {
        return esPenDown;
    }

    public void setEsPenDown(boolean esPenDown) {
        this.esPenDown = esPenDown;
    }

    public boolean isEsToCenter() {
        return esToCenter;
    }

    public void setEsToCenter(boolean esToCenter) {
        this.esToCenter = esToCenter;
    }

    public boolean isEsColor() {
        return esColor;
    }

    public void setEsColor(boolean esColor) {
        this.esColor = esColor;
    }

    public boolean isEsPositionXY() {
        return esPositionXY;
    }

    public void setEsPositionXY(boolean esPositionXY) {
        this.esPositionXY = esPositionXY;
    }

    public boolean isEsPositionX() {
        return esPositionX;
    }

    public void setEsPositionX(boolean esPositionX) {
        this.esPositionX = esPositionX;
    }

    public boolean isEsPositionY() {
        return esPositionY;
    }

    public void setEsPositionY(boolean esPositionY) {
        this.esPositionY = esPositionY;
    }

    public boolean isEsHideTurtle() {
        return esHideTurtle;
    }

    public void setEsHideTurtle(boolean esHideTurtle) {
        this.esHideTurtle = esHideTurtle;
    }

    public boolean isEsShowTurtle() {
        return esShowTurtle;
    }

    public void setEsShowTurtle(boolean esShowTurtle) {
        this.esShowTurtle = esShowTurtle;
    }

    public boolean isEsToErase() {
        return esToErase;
    }

    public void setEsToErase(boolean esToErase) {
        this.esToErase = esToErase;
    }

    public boolean isEsToDraw() {
        return esToDraw;
    }

    public void setEsToDraw(boolean esToDraw) {
        this.esToDraw = esToDraw;
    }

    public boolean isEsRepeatInicio() {
        return esRepeatInicio;
    }

    public void setEsRepeatInicio(boolean esRepeatInicio) {
        this.esRepeatInicio = esRepeatInicio;
    }

    public boolean isEsRepeatFin() {
        return esRepeatFin;
    }

    public void setEsRepeatFin(boolean esRepeatFin) {
        this.esRepeatFin = esRepeatFin;
    }
    
    
    
}
