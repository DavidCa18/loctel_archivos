/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.CentralCampo;
import Clases.CentralMarca;
import Clases.CentralModelo;
import Clases.Parametros;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CINETO
 */
public class ModeloCentral extends Conexion {

    public String guardarCentralCampo(CentralCampo ccam) {

        String mensaje = null;
        ArrayList<Parametros> lista = new ArrayList<>();
        try {
            lista.add(new Parametros("seleccion", 1));
            lista.add(new Parametros("id_campo_modelo", ccam.getIdCampoModeloCentral()));
            lista.add(new Parametros("01_cam", ccam.getCampo1Central()));
            lista.add(new Parametros("02_cam", ccam.getCampo2Central()));
            lista.add(new Parametros("03_cam", ccam.getCampo3Central()));
            lista.add(new Parametros("04_cam", ccam.getCampo4Central()));
            lista.add(new Parametros("05_cam", ccam.getCampo5Central()));
            lista.add(new Parametros("06_cam", ccam.getCampo6Central()));
            lista.add(new Parametros("07_cam", ccam.getCampo7Central()));

            mensaje = ejecutarFuncion(9, "GestionCampos", lista);

        } catch (Exception e) {
            Logger.getLogger(ModeloCentral.class.getName()).log(Level.SEVERE, null, e);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(e), "ModeloCentralCampo");
        }
        return mensaje;
    }

    public String eliminarCentralCampo(CentralCampo ccam) {

        String mensaje = null;
        ArrayList<Parametros> lista = new ArrayList<>();
        try {
            lista.add(new Parametros("seleccion", 2));
            lista.add(new Parametros("id_campo_modelo", ccam.getIdCampoModeloCentral()));
            lista.add(new Parametros("01_cam", null));
            lista.add(new Parametros("02_cam", null));
            lista.add(new Parametros("03_cam", null));
            lista.add(new Parametros("04_cam", null));
            lista.add(new Parametros("05_cam", null));
            lista.add(new Parametros("06_cam", null));
            lista.add(new Parametros("07_cam", null));

            mensaje = ejecutarFuncion(9, "GestionCampos", lista);

        } catch (Exception e) {
            Logger.getLogger(ModeloCentral.class.getName()).log(Level.SEVERE, null, e);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(e), "ModeloCentralCampo");
        }
        return mensaje;
    }

    public ArrayList<CentralModelo> buscarCentralesTelefonicas() {

        ArrayList<CentralModelo> centralModelo = new ArrayList<>();
        CentralModelo modelo;
        CentralMarca marca;

        try {
            this.conectar();
            PreparedStatement pst = this.getCn().prepareCall("SELECT * FROM buscar_central_campos");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                modelo = new CentralModelo();
                marca = new CentralMarca();

                marca.setNombreCentralMarca(rs.getString(1));
                modelo.setIdCentralModelo(rs.getInt(2));
                modelo.setNombreCentralModelo(rs.getString(3));
                modelo.setSeparadorCentralModelo(rs.getString(4));
                modelo.setCentralMarca(marca);

                centralModelo.add(modelo);

            }

        } catch (SQLException e) {
            Logger.getLogger(ModeloCentral.class.getName()).log(Level.SEVERE, null, e);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(e), "ModeloCentralCampo");
        } finally {
            this.cerrar();
        }

        return centralModelo;
    }

    public CentralModelo buscarCentralTelefonica(int idCentral) {

        CentralModelo modelo = null;
        CentralMarca marca;

        try {
            this.conectar();
            PreparedStatement pst = this.getCn().prepareCall("SELECT * FROM buscar_central_campos WHERE idModelo = " + idCentral + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                modelo = new CentralModelo();
                marca = new CentralMarca();

                marca.setNombreCentralMarca(rs.getString(1));
                modelo.setIdCentralModelo(rs.getInt(2));
                modelo.setNombreCentralModelo(rs.getString(3));
                modelo.setSeparadorCentralModelo(rs.getString(4));
                modelo.setCentralMarca(marca);

            }

        } catch (SQLException e) {
            Logger.getLogger(ModeloCentral.class.getName()).log(Level.SEVERE, null, e);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(e), "ModeloCentralCampo");
        } finally {
            this.cerrar();
        }
        return modelo;
    }

    public ArrayList<CentralMarca> buscarMarcaCentralesTelefonicas() {

        ArrayList<CentralMarca> centralMarca = new ArrayList<>();
        CentralMarca marca;

        try {
            this.conectar();
            PreparedStatement pst = this.getCn().prepareCall("SELECT * FROM marca_central");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                marca = new CentralMarca();

                marca.setNombreCentralMarca(rs.getString(2));

                centralMarca.add(marca);

            }

        } catch (SQLException e) {
            Logger.getLogger(ModeloCentral.class.getName()).log(Level.SEVERE, null, e);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(e), "ModeloCentralCampo");
        } finally {
            this.cerrar();
        }

        return centralMarca;
    }

    public ArrayList<CentralModelo> buscarModelosCentralesTelefonicas(String marca) {

        ArrayList<CentralModelo> centralModelo = new ArrayList<>();
        CentralModelo modelo;

        try {
            this.conectar();
            PreparedStatement pst = this.getCn().prepareCall("SELECT\n"
                    + "modelo_central.cen_id,\n"
                    + "modelo_central.cen_nombre\n"
                    + "FROM\n"
                    + "modelo_central\n"
                    + "INNER JOIN marca_central ON modelo_central.mar_id = marca_central.mar_id\n"
                    + "WHERE\n"
                    + "marca_central.mar_nombre = '" + marca + "'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                modelo = new CentralModelo();

                modelo.setIdCentralModelo(rs.getInt(1));
                modelo.setNombreCentralModelo(rs.getString(2));

                centralModelo.add(modelo);

            }

        } catch (SQLException e) {
            Logger.getLogger(ModeloCentral.class.getName()).log(Level.SEVERE, null, e);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(e), "ModeloCentralCampo");
        } finally {
            this.cerrar();
        }

        return centralModelo;
    }

    public CentralModelo buscarCampos(String nombreModelo) {

        CentralModelo modelo = null;
        CentralCampo campo;

        try {
            this.conectar();
            PreparedStatement pst = this.getCn().prepareStatement("{call BuscarCampos(?)}");
            pst.setString(1, nombreModelo);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                modelo = new CentralModelo();
                campo = new CentralCampo();

                modelo.setSeparadorCentralModelo(rs.getString(1));
                modelo.setNumeroProvinciaCentralModelo(rs.getString(2));
                modelo.setFormatoFechaCentralModelo(rs.getString(3));
                campo.setCampo1Central(rs.getInt(4));
                campo.setCampo2Central(rs.getInt(5));
                campo.setCampo3Central(rs.getInt(6));
                campo.setCampo4Central(rs.getInt(7));
                campo.setCampo5Central(rs.getInt(8));
                campo.setCampo6Central(rs.getInt(9));
                campo.setCampo7Central(rs.getInt(10));
                modelo.setRutaCentralModelo(rs.getString(11));
                modelo.setCentralCampo(campo);

            }

        } catch (SQLException e) {
            Logger.getLogger(ModeloCentral.class.getName()).log(Level.SEVERE, null, e);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(e), "ModeloCentralCampo");
        } finally {
            this.cerrar();
        }

        return modelo;
    }
}
