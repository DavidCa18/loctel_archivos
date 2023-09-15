/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.Parametros;
import Clases.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CINETO
 */
public class ModeloUsuario extends Conexion {

    public String validarUsuario(Usuario usu) {

        String mensaje = null;
        ArrayList<Parametros> lista = new ArrayList<>();
        try {
            lista.add(new Parametros("seleccion", 5));
            lista.add(new Parametros("id_usuario", null));
            lista.add(new Parametros("nombre_usu", usu.getNombreUsuario()));
            lista.add(new Parametros("pin_usu", usu.getPassUsuario()));
            lista.add(new Parametros("id_rol", null));

            mensaje = ejecutarFuncion(5, "GestionUsuario", lista);

        } catch (Exception e) {
            Logger.getLogger(ModeloCentral.class.getName()).log(Level.SEVERE, null, e);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(e), "ModeloUsuario");
        }
        return mensaje;
    }

    public String restablecerUsuario(Usuario usu) {

        String mensaje = null;
        ArrayList<Parametros> lista = new ArrayList<>();
        try {
            lista.add(new Parametros("seleccion", 4));
            lista.add(new Parametros("id_usuario", null));
            lista.add(new Parametros("nombre_usu", usu.getNombreUsuario()));
            lista.add(new Parametros("pin_usu", null));
            lista.add(new Parametros("id_rol", null));

            mensaje = ejecutarFuncion(5, "GestionUsuario", lista);

        } catch (Exception e) {
            Logger.getLogger(ModeloCentral.class.getName()).log(Level.SEVERE, null, e);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(e), "ModeloUsuario");
        }
        return mensaje;
    }

}
