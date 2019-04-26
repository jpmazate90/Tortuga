package tortuga;

import Analizadores.AnalizadorLexico1;
import Analizadores.parser;
import GUI.Juego;
import java.io.StringReader;

public class Tortuga {

    public static void main(String[] args) {
        try {
           Juego juego = new Juego();
           juego.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
