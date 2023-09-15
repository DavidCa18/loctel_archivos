package Controlador;

import Modelo.ModeloGestionArchivos;
import Modelo.ModeloLlamada;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class ControladorArchivosM extends SwingWorker<Void, Void> {

    private final JButton boton;
    private final JLabel estado;
    private final JComboBox combo;
    private final JComboBox combo2;
    private final String combo3;

    String mensaje = " ";
    public ModeloGestionArchivos archivos = new ModeloGestionArchivos();

    public ControladorArchivosM(JButton boton, JLabel estado, JComboBox combo, JComboBox combo2, String combo3) {
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
            archivos.cargarArchivosManualModelo1(combo);
        } else if (combo2.getSelectedItem().equals("GRANDSTREAM") || combo2.getSelectedItem().equals("ASTERISK")) {
            archivos.cargarArchivosManualModelo2(combo, combo3);
        }

        return null;
    }

    @Override
    protected void done() {
        estado.setIcon(null);
        this.estado.setText("Esperando: " + mensaje + " \n " + ModeloGestionArchivos.mensaje + " \n " + ModeloLlamada.mensaje);
        boton.setEnabled(true);
        ModeloGestionArchivos.mensaje = "";
        ModeloLlamada.mensaje = "";

    }
}
