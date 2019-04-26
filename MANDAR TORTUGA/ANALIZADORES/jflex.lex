/* codigo de usuario */
package Analizadores;

import java_cup.runtime.*;
import java.util.Date;
import javax.swing.JTextArea;
import Logica.Acciones;




%% //separador de area


 /* opciones y declaraciones de jflex */

 /* opciones y declaraciones de jflex */

%class AnalizadorLexico1
%public
%cup
%cupdebug
%line
%column

%state COMENTARIO


WhiteSpace = [\r|\n|\r\n] | [ \t\f]
SaltoLinea = [\n]

A_ = "a"|"A"
B_ = "b"|"B"
C_ = "c"|"C"
D_ = "d"|"D"
E_ = "e"|"E"
F_ = "f"|"F"
G_ = "g"|"G"
H_ = "h"|"H"
I_ = "i"|"I"
J_ = "j"|"J"
K_ = "k"|"K"
L_ = "l"|"L"
M_ = "m"|"M"
N_ = "n"|"N"
Ñ_ = "ñ"|"Ñ"
O_ = "o"|"O"
P_ = "p"|"P"
Q_ = "q"|"Q"
R_ = "r"|"R"
S_ = "s"|"S"
T_ = "t"|"T"
U_ = "u"|"U"
V_ = "v"|"V"
W_ = "w"|"W"
X_ = "x"|"X"
Y_ = "y"|"Y"
Z_ = "z"|"Z"

FORWARD = ({F_}{O_}{R_}{W_}{A_}{R_}{D_}) | ({F_}{D_})
BACKWARD = ({B_}{A_}{C_}{K_}{W_}{A_}{R_}{D_}) | ({B_}{K_})
RIGHTT = ({R_}{I_}{G_}{T_}) | ({R_}{T_})
LEFTT = ({L_}{E_}{F_}{T_}) | ({L_}{T_})
CLEARS = ({C_}{L_}{E_}{A_}{R_}{S_}) | ({C_}{S_})
PENUP = ({P_}{E_}{N_}{U_}{P_}) | ({P_}{U_})
PENDOWN = ({P_}{E_}{N_}{D_}{O_}{W_}{N_}) | ({P_}{D_})
TOCENTER = ({T_}{O_}{C_}{E_}{N_}{T_}{E_}{R_}) | ({C_}{R_})
COLOR = {C_}{O_}{L_}{O_}{R_}
POSITIONXY = ({P_}{O_}{S_}{I_}{T_}{I_}{O_}{N_}{X_}{Y_}) | ({P_}{O_}{S_}{X_}{Y_})
POSITIONX = ({P_}{O_}{S_}{I_}{T_}{I_}{O_}{N_}{X_}) | ({P_}{O_}{S_}{X_})
POSITIONY = ({P_}{O_}{S_}{I_}{T_}{I_}{O_}{N_}{Y_}) | ({P_}{O_}{S_}{Y_})
HIDETURTLE = ({H_}{I_}{D_}{E_}{T_}{U_}{R_}{T_}{L_}{E_}) | ({H_}{T_})
SHOWTURTLE = ({S_}{H_}{O_}{W_}{T_}{U_}{R_}{T_}{L_}{E_}) | ({S_}{T_})
TOERASE = ({T_}{O_}{E_}{R_}{A_}{S_}{E_}) | ({T_}{E_})
TODRAW  = ({T_}{O_}{D_}{R_}{A_}{W_}) | ({T_}{D_})
REPEAT =  {R_}{E_}{P_}{E_}{A_}{T_}


NUMERO = [0-9]
LETRA = [a-zA-Z]
LETRA_HEXA = [A-F]
GUION = "-"
GUION_BAJO = "_"
DOLLAR = "$"
NUMERAL = "#"
CORCHETE_ABIERTO = "["
CORCHETE_CERRADO = "]"
IGUAL = "="
PARENTESIS_ABIERTO = "("
PARENTESIS_CERRADO = ")"
DOS_PUNTOS = ":"
SUMA = "+"
MULTIPLICACION = "*"
DIVISION = "/"
COMA = ","

SIMBOLO_EXTRA = ({GUION}|{GUION_BAJO}|{DOLLAR})
IDD = ({DOS_PUNTOS})({LETRA}|{NUMERO}|{SIMBOLO_EXTRA})+
NUMEROS = ({NUMERO})+
NUMERO_HEXA = {NUMERO}|{LETRA_HEXA}
HEXADECIMAL = {NUMERAL}{NUMERO_HEXA}{NUMERO_HEXA}{NUMERO_HEXA}{NUMERO_HEXA}{NUMERO_HEXA}{NUMERO_HEXA}


%{
JTextArea area;
String lexema = "";
Acciones acciones;
	public AnalizadorLexico1(java.io.Reader in,JTextArea area) {
    this.zzReader = in;
    this.area = area;
acciones = new Acciones();
  }

	public void crearLexema(String mandar){
		if(lexema.equals("")){
			lexema = mandar;
		}else{
			lexema = lexema +" "+mandar;
		}
	}

  StringBuilder string = new StringBuilder();
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }


  private void error(String message) {
      System.out.println("\nError Lexico en Fila: "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message+"\n");
area.append("\nError Lexico en Fila: "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message+"\n");
      Acciones.error=true;
      acciones.ejecutarOrdenes();
      Acciones.instrucciones.clear();
  }
%}



%% /* separador de areas*/

/* reglas lexicas */
<YYINITIAL> {
{WhiteSpace} {/* IGNORAR */}
{HEXADECIMAL} {return symbol(sym.HEXADECIMAL,yytext());}
{NUMERAL} {yybegin(COMENTARIO);this.lexema = "";return symbol(sym.NUMERAL);} 
{FORWARD} {return symbol(sym.FORWARD);}
{BACKWARD} {return symbol(sym.BACKWARD);}
{RIGHTT} {return symbol(sym.RIGHTT);}
{LEFTT} {return symbol(sym.LEFTT);}
{CLEARS} {return symbol(sym.CLEARS);}
{PENUP} {return symbol(sym.PENUP);}
{PENDOWN} {return symbol(sym.PENDOWN);}
{TOCENTER} {return symbol(sym.TOCENTER);}
{COLOR} {return symbol(sym.COLOR);}
{POSITIONXY} {return symbol(sym.POSITIONXY);}
{POSITIONX} {return symbol(sym.POSITIONX);}
{POSITIONY} {return symbol(sym.POSITIONY);}
{HIDETURTLE} {return symbol(sym.HIDETURTLE);}
{SHOWTURTLE} {return symbol(sym.SHOWTURTLE);}
{TOERASE} {return symbol(sym.TOERASE);}
{TODRAW}  {return symbol(sym.TODRAW);}
{REPEAT} {return symbol(sym.REPEAT);}
{GUION} {return symbol(sym.GUION);}
{SUMA} {return symbol(sym.SUMA);}
{MULTIPLICACION} {return symbol(sym.MULTIPLICACION);}
{DIVISION} {return symbol(sym.DIVISION);}
{PARENTESIS_ABIERTO} {return symbol(sym.PARENTESIS_ABIERTO);}
{PARENTESIS_CERRADO} {return symbol(sym.PARENTESIS_CERRADO);}
{IGUAL} {return symbol(sym.IGUAL);}
{CORCHETE_ABIERTO} {Acciones.crearRepeat();return symbol(sym.CORCHETE_ABIERTO);}
{CORCHETE_CERRADO} {return symbol(sym.CORCHETE_CERRADO);}
{COMA} {return symbol(sym.COMA);}
{NUMEROS} {return symbol(sym.NUMEROS,yytext());}
{IDD} {return symbol(sym.IDD,yytext());}

}

<COMENTARIO>{
{SaltoLinea} {yybegin(YYINITIAL);return symbol(sym.COMENTARIO,this.lexema);} 
[^] {crearLexema(yytext());}
}


/* error fallback */
[^]                     {error(yytext());}
<<EOF>>                 { return symbol(sym.EOF); }





