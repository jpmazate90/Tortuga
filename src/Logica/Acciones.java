/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Analizadores.AnalizadorLexico1;
import Analizadores.parser;
import Objetos.Instruccion;
import Objetos.ObjetoTortuga;
import Objetos.Variable;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author jcsr
 */
public class Acciones {

    public static ArrayList<Instruccion> instrucciones = new ArrayList<>();
    public static ArrayList<Variable> variables = new ArrayList<>();
    public static ArrayList<String> repeats = new ArrayList<>();
    public static int posicion = 0;
    public static JTextArea area;
    public static boolean guardarEjecutar = false;
    public static File archivoEjecutar = null;
    public static boolean error = false;
    public static ObjetoTortuga tortuga;

    public static String ultimoLexema() {
        int i = repeats.size() - 1;
        return repeats.get(i);

    }

    public static void unirLexemas() {
        int i = repeats.size() - 1;
        if (i >= 1) {
            String ultimo = repeats.get(i);
            String penultimo = repeats.get(i - 1);
            penultimo = penultimo + " " + ultimo;
            repeats.remove(i);
            repeats.set(repeats.size() - 1, penultimo);
            posicion--;
        }
    }

    public static void crearRepeat() {
        String nuevo = "";
        posicion++;
        repeats.add(nuevo);
    }

    public static void generarParse(String instrucciones) {
        try {
            StringReader r = new StringReader(instrucciones);
            AnalizadorLexico1 lex = new AnalizadorLexico1(r,Acciones.area);
            parser parser = new parser(lex,Acciones.area);
            parser.parse();
            System.out.println("da");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean existeId(String id) {
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).getNombre().equals(id)) {
                return true;
            }
        }
        return false;

    }

    public static Integer valorId(String id) {
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).getNombre().equals(id)) {
                if (variables.get(i).getValor() != null) {
                    return Integer.parseInt(variables.get(i).getValor());
                } else {
                    return null;
                }

            }

        }
        return null;
    }

    public static boolean agregarVariable(Variable variable) {
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).getNombre().equals(variable.getNombre())) {
                return false;
            }
        }
        variables.add(variable);
        return true;
    }

    public static boolean agregarVariableAsignacion(Variable variable) {
        int h = -1;
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).getNombre().equals(variable.getNombre())) {
                h = i;
            }
        }
        if (h != -1) {
            variables.get(h).setNombre(variable.getNombre());
            variables.get(h).setValor(variable.getValor());
        } else {
            variables.add(variable);
        }

        return true;
    }

    public void ejecutarOrdenes() {
        try{
            tortuga.setColor("000000");
            tortuga.setColorActual("000000");
        while(instrucciones.isEmpty()==false){
            if (instrucciones.get(0).isEsForward()) {
                tortuga.accionForward(Integer.parseInt(instrucciones.get(0).getValor()));
            } else if (instrucciones.get(0).isEsBackward()) {
                tortuga.accionBackward(Integer.parseInt(instrucciones.get(0).getValor()));
            } else if (instrucciones.get(0).isEsRight()) {
                tortuga.accionRight(Integer.parseInt(instrucciones.get(0).getValor()));
            } else if (instrucciones.get(0).isEsLeft()) {
                tortuga.accionLeft(Integer.parseInt(instrucciones.get(0).getValor()));
            } else if (instrucciones.get(0).isEsClears()) {
                tortuga.accionClears();
            } else if (instrucciones.get(0).isEsPenup()) {
                tortuga.accionPenUp();
            } else if (instrucciones.get(0).isEsPenDown()) {
                tortuga.accionPenDown();
            } else if (instrucciones.get(0).isEsToCenter()) {
                tortuga.accionToCenter();
            } else if (instrucciones.get(0).isEsColor()) {
                tortuga.accionColor(instrucciones.get(0).getValor());
            } else if (instrucciones.get(0).isEsPositionXY()) {
                String x, y, lexema = instrucciones.get(0).getValor();
                int a = lexema.indexOf(",");
                x = lexema.substring(0, a);
                y = lexema.substring(a+1);
                tortuga.accionPositionxy(Integer.parseInt(x), Integer.parseInt(y));

            } else if (instrucciones.get(0).isEsPositionX()) {
                tortuga.accionPositionx(Integer.parseInt(instrucciones.get(0).getValor()));
            } else if (instrucciones.get(0).isEsPositionY()) {
                tortuga.accionPositiony(Integer.parseInt(instrucciones.get(0).getValor()));
            } else if (instrucciones.get(0).isEsHideTurtle()) {
                tortuga.accionHideTurtle();
            } else if (instrucciones.get(0).isEsShowTurtle()) {
                tortuga.accionShowTurtle();
            } else if (instrucciones.get(0).isEsToErase()) {
                tortuga.accionToErase();
            } else if (instrucciones.get(0).isEsToDraw()) {
                tortuga.accionToDraw();
            } else {
                Acciones.area.append("\n NO HAY NINGUN COMANDO");
            }
            
            instrucciones.remove(0);
        }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void reiniciarTodo() {
        variables.clear();
        instrucciones.clear();
        repeats.clear();
        guardarEjecutar = false;
        archivoEjecutar = null;
        error = false;
        Acciones.tortuga.accionClears();
        tortuga.setGrados(90);
    }
    public static void reiniciarArchivo(){
        variables.clear();
        instrucciones.clear();
        repeats.clear();
        Acciones.tortuga.accionClears();
        tortuga.setGrados(90);
    }

}
