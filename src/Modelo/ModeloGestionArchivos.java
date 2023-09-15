/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.Archivo;
import Clases.CentralModelo;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mario
 */
public class ModeloGestionArchivos {

    public static String direccion;
    public static String nombreArchivo;
    public static ModeloCentral campos;
    public static ModeloArchivo arch;
    public static Archivo arc;
    public static String mensaje = "";
    public ModeloLlamada modeloLlamada = new ModeloLlamada();

    public String guardarArchivo(Archivo archivo) throws SQLException {

        arch = new ModeloArchivo();
        return arch.guardarArchivo(archivo);

    }

    public void cargarArchivosManualModelo1(JComboBox combo) throws ParseException, SQLException {

        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtrocsv = new FileNameExtensionFilter(".csv, .txt, .log", "CSV", "TXT", "LOG");
        fc.setFileFilter(filtrocsv);
        fc.setMultiSelectionEnabled(true);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int respuesta = fc.showOpenDialog(null);

        if (respuesta == JFileChooser.APPROVE_OPTION) {

            File[] selectedFile = fc.getSelectedFiles();

            for (File selectedFile1 : selectedFile) {

                direccion = selectedFile1.getPath();
                nombreArchivo = selectedFile1.getName();

                arch = new ModeloArchivo();
                arc = new Archivo();
                arc.setNombreArchivo(nombreArchivo);
                int numero = Integer.parseInt(guardarArchivo(arc));

                if (isNumeric(String.valueOf(numero))) {
                    seleccionarArchivosModelo1(String.valueOf(numero), combo);
                } else {
                    mensaje = "Archivo ya existente en la base de datos";
                    ModeloLog ModeloLog = new ModeloLog();
                    ModeloLog.escribirLog("Archivo ya existente en la base de datos", "Gestión Archivos");
                }

            }
        } else {
            mensaje = "No se seleccionó ningún archivo";
        }
    }

    public void seleccionarArchivosModelo1(String idarchiNombre, JComboBox combo) throws ParseException, SQLException {

        String modeloCentral = combo.getSelectedItem().toString();

        campos = new ModeloCentral();
        CentralModelo centralModelo = campos.buscarCampos(modeloCentral);

        modeloLlamada.cargarCSVModelo1(direccion, centralModelo.getSeparadorCentralModelo().charAt(0),
                centralModelo.getCentralCampo().getCampo1Central(),
                centralModelo.getCentralCampo().getCampo2Central(),
                centralModelo.getCentralCampo().getCampo3Central(),
                centralModelo.getCentralCampo().getCampo4Central(),
                centralModelo.getCentralCampo().getCampo5Central(),
                centralModelo.getCentralCampo().getCampo6Central(),
                centralModelo.getCentralCampo().getCampo7Central(),
                idarchiNombre,
                nombreArchivo,
                Integer.parseInt(centralModelo.getNumeroProvinciaCentralModelo()),
                centralModelo.getFormatoFechaCentralModelo(),
                modeloCentral);

    }

    public void cargarArchivosManualModelo2(JComboBox combo, String marcaCentral) throws ParseException, SQLException {

        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtrocsv = new FileNameExtensionFilter(".csv, .txt, .log", "CSV", "TXT", "LOG");
        fc.setFileFilter(filtrocsv);
        fc.setMultiSelectionEnabled(true);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int respuesta = fc.showOpenDialog(null);

        if (respuesta == JFileChooser.APPROVE_OPTION) {

            File[] selectedFile = fc.getSelectedFiles();

            for (File selectedFile1 : selectedFile) {

                direccion = selectedFile1.getPath();
                nombreArchivo = selectedFile1.getName();

                arch = new ModeloArchivo();
                arc = new Archivo();
                arc.setNombreArchivo(nombreArchivo);
                int numero = Integer.parseInt(guardarArchivo(arc));

                if (isNumeric(String.valueOf(numero))) {
                    seleccionarArchivosModelo2(String.valueOf(numero), combo, marcaCentral);
                } else {
                    mensaje = "Archivo ya existente en la base de datos";
                    ModeloLog ModeloLog = new ModeloLog();
                    ModeloLog.escribirLog("Archivo ya existente en la base de datos", "Gestión Archivos");
                }

            }
        } else {
            mensaje = "No se seleccionó ningún archivo";
        }
    }

    public void seleccionarArchivosModelo2(String idarchiNombre, JComboBox combo, String marcaCentral) throws ParseException, SQLException {

        String modeloCentral = combo.getSelectedItem().toString();

        campos = new ModeloCentral();
        CentralModelo centralModelo = campos.buscarCampos(modeloCentral);

        modeloLlamada.cargarCSVModelo2(direccion, centralModelo.getSeparadorCentralModelo().charAt(0),
                centralModelo.getCentralCampo().getCampo1Central(),
                centralModelo.getCentralCampo().getCampo2Central(),
                centralModelo.getCentralCampo().getCampo3Central(),
                centralModelo.getCentralCampo().getCampo4Central(),
                centralModelo.getCentralCampo().getCampo5Central(),
                centralModelo.getCentralCampo().getCampo6Central(),
                centralModelo.getCentralCampo().getCampo7Central(),
                idarchiNombre,
                nombreArchivo,
                Integer.parseInt(centralModelo.getNumeroProvinciaCentralModelo()),
                centralModelo.getFormatoFechaCentralModelo(),
                modeloCentral,
                marcaCentral);

    }

    public boolean isNumeric(String cadena) {
        try {
            Long.parseLong(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void cargarArchivosAutomaticoModelo1(JComboBox combo) throws ParseException, SQLException {

        String modeloCentral = combo.getSelectedItem().toString();
        arch = new ModeloArchivo();
        arc = new Archivo();

        campos = new ModeloCentral();
        CentralModelo centralModelo = campos.buscarCampos(modeloCentral);

        String sDirectorio = centralModelo.getRutaCentralModelo();
        File f = new File(sDirectorio);
        if (f.exists()) {
            File[] ficheros = f.listFiles();
            for (int i = 0; i < 10; i++) {

                arc.setNombreArchivo(ficheros[i].getName());
                int numero = Integer.parseInt(guardarArchivo(arc));

                if (isNumeric(String.valueOf(numero))) {

                    modeloLlamada.cargarCSVModelo1(ficheros[i].getPath(), centralModelo.getSeparadorCentralModelo().charAt(0),
                            centralModelo.getCentralCampo().getCampo1Central(),
                            centralModelo.getCentralCampo().getCampo2Central(),
                            centralModelo.getCentralCampo().getCampo3Central(),
                            centralModelo.getCentralCampo().getCampo4Central(),
                            centralModelo.getCentralCampo().getCampo5Central(),
                            centralModelo.getCentralCampo().getCampo6Central(),
                            centralModelo.getCentralCampo().getCampo7Central(),
                            String.valueOf(numero),
                            ficheros[i].getName(),
                            Integer.parseInt(centralModelo.getNumeroProvinciaCentralModelo()),
                            centralModelo.getFormatoFechaCentralModelo(),
                            modeloCentral);
                } else {
                    mensaje = "Archivo ya existente en la base de datos";
                    ModeloLog ModeloLog = new ModeloLog();
                    ModeloLog.escribirLog("Archivo ya existente en la base de datos", "Gestión Archivos");
                }

            }
        } else {
            mensaje = "No existen archivos en la ruta asignada";
        }
    }

    public void cargarArchivosAutomaticoModelo2(JComboBox combo, String marcaCentral) throws ParseException, SQLException {

        String modeloCentral = combo.getSelectedItem().toString();
        arch = new ModeloArchivo();
        arc = new Archivo();

        campos = new ModeloCentral();
        CentralModelo centralModelo = campos.buscarCampos(modeloCentral);

        String sDirectorio = centralModelo.getRutaCentralModelo();
        File f = new File(sDirectorio);
        if (f.exists()) {
            File[] ficheros = f.listFiles();
            for (int i = 0; i < 10; i++) {

                arc.setNombreArchivo(ficheros[i].getName());
                int numero = Integer.parseInt(guardarArchivo(arc));

                if (isNumeric(String.valueOf(numero))) {

                    modeloLlamada.cargarCSVModelo2(ficheros[i].getPath(), centralModelo.getSeparadorCentralModelo().charAt(0),
                            centralModelo.getCentralCampo().getCampo1Central(),
                            centralModelo.getCentralCampo().getCampo2Central(),
                            centralModelo.getCentralCampo().getCampo3Central(),
                            centralModelo.getCentralCampo().getCampo4Central(),
                            centralModelo.getCentralCampo().getCampo5Central(),
                            centralModelo.getCentralCampo().getCampo6Central(),
                            centralModelo.getCentralCampo().getCampo7Central(),
                            String.valueOf(numero),
                            ficheros[i].getName(),
                            Integer.parseInt(centralModelo.getNumeroProvinciaCentralModelo()),
                            centralModelo.getFormatoFechaCentralModelo(),
                            modeloCentral,
                            marcaCentral);
                } else {
                    mensaje = "Archivo ya existente en la base de datos";
                    ModeloLog ModeloLog = new ModeloLog();
                    ModeloLog.escribirLog("Archivo ya existente en la base de datos", "Gestión Archivos");
                }

            }
        } else {
            mensaje = "No existen archivos en la ruta asignada";
        }
    }

}
