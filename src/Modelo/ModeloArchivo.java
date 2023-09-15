/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.Archivo;
import Clases.Parametros;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CINETO
 */
public class ModeloArchivo extends Conexion {

    public String guardarArchivo(Archivo archi) {

        String mensaje = null;
        ArrayList<Parametros> lista = new ArrayList<>();
        try {
            lista.add(new Parametros("seleccion", 1));
            lista.add(new Parametros("nombre_archivo", archi.getNombreArchivo()));

            mensaje = ejecutarFuncion(2, "GestionArchivo", lista);

        } catch (Exception e) {
            Logger.getLogger(ModeloCentral.class.getName()).log(Level.SEVERE, null, e);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(e), "ModeloArchivo");
        }
        return mensaje;
    }

    public String eliminarArchivo(Archivo archi) {

        String mensaje = null;
        ArrayList<Parametros> lista = new ArrayList<>();
        try {
            lista.add(new Parametros("seleccion", 2));
            lista.add(new Parametros("nombre_archivo", archi.getNombreArchivo()));

            mensaje = ejecutarFuncion(2, "GestionArchivo", lista);

        } catch (Exception e) {
            Logger.getLogger(ModeloCentral.class.getName()).log(Level.SEVERE, null, e);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(e), "ModeloArchivo");
        }
        return mensaje;
    }
}
