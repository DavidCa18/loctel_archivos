/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.Parametros;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CINETO
 */
public class ModeloLog extends Conexion{


    public void escribirLog(String error, String clase) {
        
        ArrayList<Parametros> lista = new ArrayList<>();
        try {
            lista.add(new Parametros("seleccion", 1));
            lista.add(new Parametros("error_tipo", "Error"));
            lista.add(new Parametros("error_modulo", clase));
            lista.add(new Parametros("error_mensaje", error));

            ejecutarFuncion(4, "GestionError", lista);

        } catch (Exception e) {
            Logger.getLogger(ModeloLog.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
