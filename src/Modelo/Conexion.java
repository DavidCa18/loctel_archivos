/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.Parametros;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    private BufferedReader br;
    private Connection cn;
    private String host;
    private String port;
    private String database;
    private String user;
    private String password;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void leerArchivo() {

        try {
            File archivo = new File("C:\\LoctelCineto\\Configuracion Base de Datos\\configuracionBD.txt");
            FileReader fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            host = br.readLine();
            port = br.readLine();
            database = br.readLine();
            user = br.readLine();
            password = br.readLine();

            host = host.substring(22, host.length());
            port = port.substring(6, port.length());
            database = database.substring(10, database.length());
            user = user.substring(6, user.length());
            password = password.substring(10, password.length());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Por favor comunicarse con el\nadministrador de la base de datos\nse corregirá el error aceptando\nlos permisos de administrador en la ventana\n que se abrirá a continuación" + e, "Error al leer el archivo\n", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    public void conectar() {
        leerArchivo();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            
        }

    }

    public void cerrar() {

        try {
            if (cn != null) {

                if (cn.isClosed() == false) {
                    cn.close();
                }

            }
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            
        }

    }

    public String ejecutarFuncion(int numero, String nombreSp, ArrayList<Parametros> lista) throws Exception {

        String mensaje = null;
        try {
            this.conectar();
            CallableStatement stn = this.getCn().prepareCall("{? = call " + nombreSp + "(" + numeroParametros(numero) + ")}");
            stn.registerOutParameter(1, java.sql.Types.VARCHAR);
            for (int i = 0; i < lista.size(); i++) {
                stn.setObject(lista.get(i).nombre, lista.get(i).valor);
            }
            stn.execute();
            mensaje = stn.getString(1);

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            this.cerrar();
        }
        return mensaje;
    }

    public static String numeroParametros(int numero) {
        String valor;
        String concatenado = "";
        String total;
        for (int i = 0; i < numero; i++) {
            valor = "?,";
            concatenado = concatenado + valor;
        }
        total = concatenado.substring(0, concatenado.length() - 1);
        return total;
    }

}
