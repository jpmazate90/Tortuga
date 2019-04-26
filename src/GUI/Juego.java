package GUI;

import Analizadores.AnalizadorLexico1;
import Analizadores.parser;
import Logica.Acciones;
import Logica.CargaArchivo;
import Objetos.ObjetoTortuga;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Juego extends javax.swing.JFrame {

    private String archivoALeer;
    private String nombreArchivoALeer;
    private File archivo;
    private int posX1 = 400;
    private int posY1 = 200;
    private int posX2 = 580;
    private int posY2 = 200;
    private int grados;
    private String color = "000000";
    private String colorActual = "000000";
    private boolean mostrar = true;
    private boolean lapicero = true;

    private ObjetoTortuga tortuga;
    private Acciones acciones;
    private CargaArchivo carga;

    public Juego() {
        initComponents();
        tortuga = new ObjetoTortuga();
        panelTortuga.add(tortuga);
        Acciones.area = this.textMensajes;
        Acciones.tortuga = this.tortuga;
        acciones = new Acciones();
        carga = new CargaArchivo();
        tortuga.accionClears();

    }

    

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    public void ejecutar() {
        try {
            Acciones.reiniciarTodo();
            textHistorial.append(textComandos.getText()+"\n");
            textComandos.setText("");
            StringReader leedor = new StringReader(textHistorial.getText()+"\n");
            AnalizadorLexico1 miLexer = new AnalizadorLexico1(leedor, textMensajes);
            parser miParser = new parser(miLexer, textMensajes);
            miParser.parse();
            if (Acciones.error == false) {
                acciones.ejecutarOrdenes();
            }
        } catch (Exception e) {
            Acciones.error = false;
        }

    }

    public void reiniciarTodo() {
        textComandos.setText("");
        textHistorial.setText("");
        textMensajes.setText("");
        Acciones.reiniciarTodo();
    }

    public void guardarComandos() {
        carga.guardarComoArchivo(textHistorial);
    }
    
    public void cargarArchivo() {
        //crea un file chooser para escoger el archivo a evaluar
        JFileChooser buscadorArchivos = new JFileChooser();
        int opcion = buscadorArchivos.showOpenDialog(this);
        // si se acepta el archivo entra
        if (opcion == JFileChooser.APPROVE_OPTION) {
            String archivo = buscadorArchivos.getSelectedFile().getAbsolutePath();
            String archivo1 = buscadorArchivos.getSelectedFile().toString();
            // si se encuentra el archivo pide el tiempo en milisegundos
            System.out.println("Se ha encontrado el archivo: " + archivo1);
            try {

                this.archivoALeer = archivo;
                this.nombreArchivoALeer = archivo1;
                this.archivo = new File(archivoALeer);
                if (this.archivo.exists()) {

                    if (archivo1.endsWith(".kok")) {
                        Acciones.archivoEjecutar = null;
                        Acciones.guardarEjecutar = false;
                        EditorTexto text = new EditorTexto(this, true, this.archivo);
                        text.setVisible(true);

                        if (Acciones.guardarEjecutar == true) {
                            try {
                                Acciones.reiniciarArchivo();
                                textMensajes.setText("");
                                textComandos.setText("");
                                textHistorial.setText("");
                                textHistorial.append(carga.mensajesArchivo(Acciones.archivoEjecutar)+"\n");
                                FileReader r = new FileReader(Acciones.archivoEjecutar);
                                AnalizadorLexico1 lex = new AnalizadorLexico1(r, textMensajes);
                                parser p = new parser(lex, textMensajes);
                                p.parse();
                                if (Acciones.error == false) {
                                    acciones.ejecutarOrdenes();
                                }
                                Acciones.archivoEjecutar = null;
                                Acciones.guardarEjecutar = false;
                            } catch (Exception e) {
                                Acciones.archivoEjecutar = null;
                                Acciones.guardarEjecutar = false;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El archivo: " + archivo + "no es .kok");
                    }

                }

            } catch (Exception e) {
                System.out.println("Hubo algun error");

            }
        } else if (opcion == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No se ha cargado ningun archivo");
        }
        try {
            // crea el archivo que se selecciono

        } catch (Exception e) {
            System.out.println("No se selecciono ningun archivo");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textComandos = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        textHistorial = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textMensajes = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        panelTortuga = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("COMANDOS");

        textComandos.setColumns(20);
        textComandos.setRows(5);
        jScrollPane1.setViewportView(textComandos);

        jButton2.setText("EJECUTAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        textHistorial.setColumns(20);
        textHistorial.setRows(5);
        jScrollPane3.setViewportView(textHistorial);

        jLabel3.setText("Historial");

        jButton1.setText("GUARDAR COMANDOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jLabel3)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)))
        );

        desktopPane.add(jPanel1);
        jPanel1.setBounds(0, 330, 490, 230);

        jLabel2.setText("MENSAJES");

        textMensajes.setEditable(false);
        textMensajes.setColumns(20);
        textMensajes.setRows(5);
        jScrollPane2.setViewportView(textMensajes);

        jButton3.setText("REINICIAR TODO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(143, 143, 143))
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
        );

        desktopPane.add(jPanel2);
        jPanel2.setBounds(490, 330, 420, 230);

        javax.swing.GroupLayout panelTortugaLayout = new javax.swing.GroupLayout(panelTortuga);
        panelTortuga.setLayout(panelTortugaLayout);
        panelTortugaLayout.setHorizontalGroup(
            panelTortugaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        panelTortugaLayout.setVerticalGroup(
            panelTortugaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        desktopPane.add(panelTortuga);
        panelTortuga.setBounds(0, 0, 910, 320);

        helpMenu.setMnemonic('h');
        helpMenu.setText("CARGAR ARCHIVO");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("CARGAR");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        cargarArchivo();
    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ejecutar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reiniciarTodo();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardarComandos();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panelTortuga;
    private javax.swing.JTextArea textComandos;
    private javax.swing.JTextArea textHistorial;
    private javax.swing.JTextArea textMensajes;
    // End of variables declaration//GEN-END:variables

    public void paint(Graphics g) {
        super.paint(g);
        if (mostrar) {
            g.fillOval(posX1, posY1, 16, 16);
            g.drawOval(posX1 - 3, posY1 - 1, 5, 5);
            g.drawOval(posX1 - 3, posY1 + 10, 5, 5);
            g.drawOval(posX1 + 14, posY1 - 1, 5, 5);
            g.drawOval(posX1 + 15, posY1 + 10, 5, 5);
            g.drawOval(posX1 + 5, posY1 - 5, 6, 6);
        }

    }

}
