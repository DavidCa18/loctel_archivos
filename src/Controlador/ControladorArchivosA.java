/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloGestionArchivos;
import Modelo.ModeloLlamada;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 *
 * @author mario
 */
public class ControladorArchivosA extends SwingWorker<Void, Void> {

    private final JButton boton;
    private final JLabel estado;
    private final JComboBox combo;
    private final JComboBox combo2;
    private final String combo3;
    String mensaje = " ";
    public ModeloGestionArchivos modeloArchivos = new ModeloGestionArchivos();

    public ControladorArchivosA(JButton boton, JLabel estado, JComboBox combo, JComboBox combo2, String combo3) {
        this.boton = boton;
        this.estado = estado;
        this.combo = combo;
        this.combo2 = combo2;
        this.combo3 = combo3;
    }

    @Override
    protected Void doInBackground() throws Exception {

        estado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Esperando.gif")));
        this.estado.setText("Estado: Subiendo, por favor espere...\n");
        this.boton.setEnabled(false);

        if (combo2.getSelectedItem().equals("EPYGI")) {
            modeloArchivos.cargarArchivosAutomaticoModelo1(combo);
        } else if (combo2.getSelectedItem().equals("GRANDSTREAM") || combo2.getSelectedItem().equals("ASTERISK")) {
            modeloArchivos.cargarArchivosAutomaticoModelo2(combo, combo3);
        }

        return null;
    }

    protected void done() {
        estado.setIcon(null);
        this.estado.setText("Esperando: " + mensaje + " \n" + ModeloGestionArchivos.mensaje + " \n " + ModeloLlamada.mensaje);
        ModeloGestionArchivos.mensaje = "";
        ModeloLlamada.mensaje = "";
    }
}
