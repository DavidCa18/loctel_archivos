/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.Archivo;
import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author CINETO
 */
public class ModeloLlamada extends Conexion {

    public static ModeloArchivo modeloArchivo;
    public static Archivo archivos;
    public static String mensaje = "";

    public static void eliminarArchivo(String archivo) throws SQLException {

        modeloArchivo = new ModeloArchivo();
        archivos = new Archivo();
        archivos.setNombreArchivo(archivo);
        modeloArchivo.eliminarArchivo(archivos);

    }

    public void CargaraBaseDatosModelo1(String datos, String nombreArchivo, String ruta) throws SQLException {

        PreparedStatement pst;
        String sqls = "INSERT INTO llamada (lla_tipo, lla_fecha, lla_duracion, lla_tipo_origen, lla_numero_origen, lla_tipo_destino, lla_numero_destino, ope_id, ext_numero, arc_id, lla_central, lla_modelo_central) VALUES ";

        try {
            this.conectar();
            pst = this.getCn().prepareStatement(sqls + datos);
            pst.executeUpdate();
            mensaje = "Archivo guardado Correctamente";
            moverArchivo(ruta);
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLlamada.class.getName()).log(Level.SEVERE, null, ex);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(ex), "ModeloLlamada");
            eliminarArchivo(nombreArchivo);
            mensaje = "Error al subir el archivo\n";
        } finally {
            this.cerrar();
        }

    }

    public void cargarCSVModelo1(String ruta, Character separador, int valor1, int valor2, int valor3, int valor4, int valor5, int valor6, int valor7, String idArchivo, String nombreArchivo, int numeracion, String formato, String modeloCentral) {

        char QUOTE = '"';

        CSVReader reader = null;
        String valor;
        String concatenado = "";
        try {

            reader = new CSVReader(new FileReader(ruta), separador, QUOTE);
            String[] nextLine = null;

            while ((nextLine = reader.readNext()) != null) {
                String[] datos = nextLine;
                datos[8] = "";
                if (datos[0].matches(".*Call.*")) {

                    if (formato.equals("1")) {
                        datos[valor1] = "NOTHING";
                        datos[valor2] = "01-Jan-1999 00:00:00";
                        datos[valor3] = "0";
                        datos[valor4] = "INVALID";
                        datos[valor5] = "INVALID";
                        datos[valor6] = "INVALID";
                        datos[valor7] = "INVALID";
                        datos[7] = "1";
                        datos[8] = "00";
                        datos[9] = "1";
                    }
                    if (formato.equals("2")) {
                        datos[valor1] = "NOTHING";
                        datos[valor2] = "01-01-1999 00:00:00";
                        datos[valor3] = "0";
                        datos[valor4] = "INVALID";
                        datos[valor5] = "INVALID";
                        datos[valor6] = "INVALID";
                        datos[valor7] = "INVALID";
                        datos[7] = "1";
                        datos[8] = "00";
                        datos[9] = "1";
                    }

                }

                reemplazar(valor5, "\"", "", datos);
                reemplazar(valor5, "_", " ", datos);
                reemplazar(valor7, "_", " ", datos);
                reemplazar(valor7, "\"", "", datos);
                reemplazar(valor7, "/", "", datos);
                reemplazar(valor5, ">", "", datos);
                reemplazar(valor5, "(00)", "", datos);
                reemplazar(valor5, "?", "00", datos);
                reemplazar(valor5, "(", "", datos);
                reemplazar(valor5, ")", "", datos);
                reemplazar(valor7, "?", "00", datos);
                reemplazar(valor7, "(", "", datos);
                reemplazar(valor7, ")", "", datos);
                separar(valor5, 0, "/", datos);
                separar(valor5, 0, "@", datos);
                separar(valor7, 0, "@", datos);
                separar(valor5, 1, "-", datos);
                separar(valor7, 1, "-", datos);
                separar(valor5, 1, "<", datos);
                agregar(valor7, datos);
                asignarFecha(datos, formato);

                asignarOperadorasModelo1(valor7, valor4, valor6, datos, 2);
                asingarExtensiones2(datos, valor5, valor7);
                asingarExtensiones(datos, valor5, valor7);

                valor = "('" + datos[valor1] + "','" + datos[valor2] + "','" + datos[valor3] + "','" + datos[valor4] + "','" + datos[valor5] + "','" + datos[valor6] + "','" + datos[valor7] + "','" + datos[7] + "','" + datos[8] + "','" + idArchivo + "', 'EPYGI', '" + modeloCentral + "'),\n";
                concatenado = concatenado + valor;
            }
            String sqla = concatenado.substring(0, concatenado.length() - 2);
            System.out.println(sqla);
            CargaraBaseDatosModelo1(sqla, nombreArchivo, ruta);
        } catch (IOException | SQLException | ParseException ex) {
            Logger.getLogger(ModeloLlamada.class.getName()).log(Level.SEVERE, null, ex);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(ex), "ModeloLlamada");
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(ModeloLlamada.class.getName()).log(Level.SEVERE, null, ex);
                    ModeloLog ModeloLog = new ModeloLog();
                    ModeloLog.escribirLog(String.valueOf(ex), "ModeloLlamada");
                }
            }
        }
    }

    public void cargarCSVModelo2(String ruta, Character separador, int valor1, int valor2, int valor3, int valor4, int valor5, int valor6, int valor7, String idArchivo, String nombreArchivo, int numeracion, String formato, String modeloCentral, String marcaCentral) {

        char QUOTE = '"';

        CSVReader reader = null;
        String valor;
        String concatenado = "";
        try {

            reader = new CSVReader(new FileReader(ruta), separador, QUOTE);
            String[] nextLine = null;

            while ((nextLine = reader.readNext()) != null) {
                String[] datos = nextLine;

                if (datos[0].matches(".*account.*")) {

                    datos[valor1] = "NOTHING";
                    datos[valor2] = "1999-01-01";
                    datos[valor3] = "0";
                    datos[valor4] = "NOTHING";
                    datos[valor5] = "NOTHING";
                    datos[valor6] = "NOTHING";
                    datos[valor7] = "NOTHING";
                    datos[7] = "1";
                    datos[8] = "00";
                    datos[9] = "1999-01-02";

                } else if (datos[0].matches(".*calldate.*")) {
                    datos[valor1] = "NOTHING";
                    datos[valor2] = "1999-01-01";
                    datos[valor3] = "0";
                    datos[valor4] = "NOTHING";
                    datos[valor5] = "NOTHING";
                    datos[valor6] = "NOTHING";
                    datos[valor7] = "NOTHING";
                    datos[7] = "1";
                    datos[8] = "00";
                    datos[9] = "0";
                }

                reemplazar(valor6, "\"", "", datos);
                reemplazar(valor6, "<", " ", datos);
                reemplazar(valor6, ">", " ", datos);

                asignarOperadorasModelo2(valor7, datos, 2);

                valor = "('" + datos[valor1] + "','" + datos[valor2] + "','" + datos[valor3] + "','" + datos[valor4] + "','" + datos[valor5] + "','" + datos[valor6] + "','" + datos[valor7] + "','" + datos[7] + "',null,'" + idArchivo + "', '" + marcaCentral + "', '" + modeloCentral + "'),\n";
                concatenado = concatenado + valor;
            }
            String sqla = concatenado.substring(0, concatenado.length() - 2);
            // System.out.println(sqla);
            CargaraBaseDatosModelo1(sqla, nombreArchivo, ruta);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(ModeloLlamada.class.getName()).log(Level.SEVERE, null, ex);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(ex), "ModeloLlamada");
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(ModeloLlamada.class.getName()).log(Level.SEVERE, null, ex);
                    ModeloLog ModeloLog = new ModeloLog();
                    ModeloLog.escribirLog(String.valueOf(ex), "ModeloLlamada");
                }
            }
        }
    }

    public static void reemplazar(int vect, String valor, String reemplazo, String[] datos) {

        String primerValor = datos[vect];
        String segundoValor = primerValor.replace(valor, reemplazo);
        datos[vect] = segundoValor;

    }

    public static void separar(int vect, int orden, String valor, String[] datos) {

        if (datos[vect].matches(".*" + valor + ".*")) {
            String cadena = datos[vect];
            String cadenaarray[] = cadena.split(valor);
            datos[vect] = cadenaarray[orden];

        }

    }

    public static void reemplazarNumExt(String[] datos, int columna, String valor, String reemplazo) {

        if (datos[columna].matches(".*" + valor + "(?=\\s).*")
                && datos[columna].matches(".*" + valor + "(\\s=?).*")) {

            String primerValor = datos[columna];
            String segundoValor = primerValor.replace(" " + valor + " ", reemplazo);
            datos[columna] = segundoValor;

        }
    }

    public static void agregar(int vect, String[] datos) {

        if (datos[vect].length() == 8) {

            String primerValor = datos[vect];
            String segundoValor = "0" + primerValor;
            datos[vect] = segundoValor;
        }

    }

    public static void asignarFecha(String[] datos, String formato) throws ParseException {

        String fechaIni = datos[1];
        datos[1] = convertirFecha(fechaIni, formato);

    }

    public static String convertirFecha(String fecha, String formato) throws ParseException {

        String formatFecha = null;
        try {

            if (formato.equals("1")) {

                Date date = new Date(fecha);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                formatFecha = formatter.format(date);

            }
            if (formato.equals("2")) {
                String date_s = fecha;
                SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                Date date = dt.parse(date_s);
                SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                formatFecha = dt1.format(date);
            }

        } catch (ParseException e) {
            Logger.getLogger(ModeloLog.class.getName()).log(Level.SEVERE, null, e);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(e), "ModeloLlamada");
        }
        return formatFecha;
    }

    public static boolean isNumeric(String cadena) {
        try {
            Long.parseLong(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNotNumeric(String cadena) {

        try {
            Long.parseLong(cadena);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static boolean validar(String cadena) {
        Pattern pat = Pattern.compile("[a-zA-Z0-9-\\s]{1,}[\\s][a-zA-Z0-9]{1,}[\\s][0-9]{1,}");
        Matcher mat = pat.matcher(cadena);
        return mat.matches();
    }

    public static void asingarExtensiones(String[] datos, int numOrigen, int numDestino) {

        if (validar(datos[numOrigen]) && isNotNumeric(datos[numOrigen])) {
            String[] split = datos[numOrigen].split(" ");
            datos[8] = split[split.length - 1];
        }
        if (validar(datos[numDestino]) && isNumeric(datos[numOrigen])) {
            String[] split = datos[numDestino].split(" ");
            datos[8] = split[split.length - 1];
        }
        if (validar(datos[8]) && isNotNumeric(datos[8])) {
            String[] split = datos[numDestino].split(" ");
            datos[8] = split[split.length - 1];
        }
        if (isNumeric(datos[numOrigen]) && isNumeric(datos[numDestino])) {
            datos[8] = "00";
        }
        if (datos[numDestino].matches("SIMS.*")) {
            datos[8] = "00";
        }
        if (datos[8] == null || datos[8].equals("")) {
            datos[8] = "00";
        }
    }

    public static void asingarExtensiones2(String[] datos, int numOrigen, int numDestino) {

        if (isNotNumeric(datos[numOrigen])) {
            String primerValor = datos[numOrigen];
            String segundoValor = primerValor.replaceAll("[A-Z]|[a-z]| |_|:", "");
            datos[8] = segundoValor;
        }
        if (isNumeric(datos[numOrigen])) {
            String primerValor = datos[numDestino];
            String segundoValor = primerValor.replaceAll("[A-Z]|[a-z]| |_|:", "");
            datos[8] = segundoValor;
        }
        if (isNotNumeric(datos[8])) {
            String primerValor = datos[numDestino];
            String segundoValor = primerValor.replaceAll("[A-Z]|[a-z]| |_|:", "");
            datos[8] = segundoValor;
        }
        if (isNumeric(datos[numOrigen]) && isNumeric(datos[numDestino])) {
            datos[8] = "00";
        }
        if (datos[numDestino].matches("SIMS.*")) {
            datos[8] = "00";
        }
        if (datos[8] == null || datos[8].equals("")) {
            datos[8] = "00";
        }

    }

    public void asignarOperadorasModelo1(int vecComparacion, int tipOrigen, int tipDes, String[] datos, int numeracion) throws SQLException {

        Statement st;

        if (datos[vecComparacion].trim().length() == 7 && isNumeric(datos[vecComparacion].trim())) {

            try {
                this.conectar();
                st = this.getCn().createStatement();
                ResultSet rs = st.executeQuery("SELECT operadora.ope_id FROM operadora \n"
                        + "			WHERE operadora.ope_numeracion=" + numeracion + " \n"
                        + "			AND " + datos[vecComparacion].trim() + " BETWEEN operadora.ope_serie_inicio AND operadora.ope_serie_fin");
                while (rs.next()) {
                    datos[7] = rs.getString(1);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ModeloLlamada.class.getName()).log(Level.SEVERE, null, ex);
                ModeloLog ModeloLog = new ModeloLog();
                ModeloLog.escribirLog(String.valueOf(ex), "ModeloLlamada");
            } finally {
                this.cerrar();
            }

        }
        if (datos[vecComparacion].trim().length() == 9 && isNumeric(datos[vecComparacion].trim())) {

            try {
                this.conectar();
                st = this.getCn().createStatement();
                ResultSet rs = st.executeQuery("SELECT operadora.ope_id FROM operadora \n"
                        + "			WHERE operadora.ope_numeracion=SUBSTRING('" + datos[vecComparacion].trim() + "',2,1) \n"
                        + "			AND SUBSTRING('" + datos[vecComparacion].trim() + "',3) BETWEEN operadora.ope_serie_inicio AND operadora.ope_serie_fin");
                while (rs.next()) {
                    datos[7] = rs.getString(1);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ModeloLlamada.class.getName()).log(Level.SEVERE, null, ex);
                ModeloLog ModeloLog = new ModeloLog();
                ModeloLog.escribirLog(String.valueOf(ex), "ModeloLlamada");
            } finally {
                this.cerrar();
            }

        }
        if (datos[vecComparacion].trim().length() == 10 && isNumeric(datos[vecComparacion].trim())) {

            try {
                this.conectar();
                st = this.getCn().createStatement();
                ResultSet rs = st.executeQuery("SELECT operadora.ope_id FROM operadora \n"
                        + "			WHERE operadora.ope_numeracion=SUBSTRING('" + datos[vecComparacion].trim() + "',2,2) \n"
                        + "			AND SUBSTRING('" + datos[vecComparacion].trim() + "',4) BETWEEN operadora.ope_serie_inicio AND operadora.ope_serie_fin");
                while (rs.next()) {
                    datos[7] = rs.getString(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ModeloLlamada.class.getName()).log(Level.SEVERE, null, ex);
                ModeloLog ModeloLog = new ModeloLog();
                ModeloLog.escribirLog(String.valueOf(ex), "ModeloLlamada");
            } finally {
                this.cerrar();
            }

        }

        if (datos[vecComparacion].trim().length() == 10 && isNumeric(datos[vecComparacion].trim()) && (datos[vecComparacion].substring(0, 4).trim().equals("1700") || datos[vecComparacion].substring(0, 4).trim().equals("1800"))) {

            try {
                this.conectar();
                st = this.getCn().createStatement();
                ResultSet rs = st.executeQuery("SELECT operadora.ope_id FROM operadora \n"
                        + "			WHERE operadora.ope_numeracion=SUBSTRING('" + datos[vecComparacion].trim() + "',1,4) \n"
                        + "			AND SUBSTRING('" + datos[vecComparacion].trim() + "',5,10) BETWEEN operadora.ope_serie_inicio AND operadora.ope_serie_fin");
                while (rs.next()) {
                    datos[7] = rs.getString(1);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ModeloLlamada.class.getName()).log(Level.SEVERE, null, ex);
                ModeloLog ModeloLog = new ModeloLog();
                ModeloLog.escribirLog(String.valueOf(ex), "ModeloLlamada");
            } finally {
                this.cerrar();
            }

        }
        if (datos[tipOrigen].trim().equals("PBX") && datos[tipDes].trim().equals("PBX") && isNotNumeric(datos[vecComparacion].trim())) {

            datos[7] = "3103";

        }
        if (datos[vecComparacion].trim().length() >= 10
                && (datos[vecComparacion].substring(0, 2).equals("00"))
                && datos[tipDes].equals("FXO")) {

            datos[7] = "2";

        }
        if (datos[vecComparacion].trim().length() == 3 && isNumeric(datos[vecComparacion].trim())) {

            datos[7] = "3";

        }
        if (datos[7] == null || datos[7].equals("") || isNotNumeric(datos[7])) {

            datos[7] = "1";

        }
    }

    public void asignarOperadorasModelo2(int vecComparacion, String[] datos, int numeracion) throws SQLException {

        Statement st;

        if (datos[vecComparacion].trim().length() == 7 && isNumeric(datos[vecComparacion].trim())) {

            try {
                this.conectar();
                st = this.getCn().createStatement();
                ResultSet rs = st.executeQuery("SELECT operadora.ope_id FROM operadora \n"
                        + "			WHERE operadora.ope_numeracion=" + numeracion + " \n"
                        + "			AND " + datos[vecComparacion].trim() + " BETWEEN operadora.ope_serie_inicio AND operadora.ope_serie_fin");
                while (rs.next()) {
                    datos[7] = rs.getString(1);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ModeloLlamada.class.getName()).log(Level.SEVERE, null, ex);
                ModeloLog ModeloLog = new ModeloLog();
                ModeloLog.escribirLog(String.valueOf(ex), "ModeloLlamada");
            } finally {
                this.cerrar();
            }

        }
        if (datos[vecComparacion].trim().length() == 9 && isNumeric(datos[vecComparacion].trim())) {

            try {
                this.conectar();
                st = this.getCn().createStatement();
                ResultSet rs = st.executeQuery("SELECT operadora.ope_id FROM operadora \n"
                        + "			WHERE operadora.ope_numeracion=SUBSTRING('" + datos[vecComparacion].trim() + "',2,1) \n"
                        + "			AND SUBSTRING('" + datos[vecComparacion].trim() + "',3) BETWEEN operadora.ope_serie_inicio AND operadora.ope_serie_fin");
                while (rs.next()) {
                    datos[7] = rs.getString(1);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ModeloLlamada.class.getName()).log(Level.SEVERE, null, ex);
                ModeloLog ModeloLog = new ModeloLog();
                ModeloLog.escribirLog(String.valueOf(ex), "ModeloLlamada");
            } finally {
                this.cerrar();
            }

        }
        if (datos[vecComparacion].trim().length() == 10 && isNumeric(datos[vecComparacion].trim())) {

            try {
                this.conectar();
                st = this.getCn().createStatement();
                ResultSet rs = st.executeQuery("SELECT operadora.ope_id FROM operadora \n"
                        + "			WHERE operadora.ope_numeracion=SUBSTRING('" + datos[vecComparacion].trim() + "',2,2) \n"
                        + "			AND SUBSTRING('" + datos[vecComparacion].trim() + "',4) BETWEEN operadora.ope_serie_inicio AND operadora.ope_serie_fin");
                while (rs.next()) {
                    datos[7] = rs.getString(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ModeloLlamada.class.getName()).log(Level.SEVERE, null, ex);
                ModeloLog ModeloLog = new ModeloLog();
                ModeloLog.escribirLog(String.valueOf(ex), "ModeloLlamada");
            } finally {
                this.cerrar();
            }

        }

        if (datos[vecComparacion].trim().length() == 10 && isNumeric(datos[vecComparacion].trim()) && (datos[vecComparacion].substring(0, 4).trim().equals("1700") || datos[vecComparacion].substring(0, 4).trim().equals("1800"))) {

            try {
                this.conectar();
                st = this.getCn().createStatement();
                ResultSet rs = st.executeQuery("SELECT operadora.ope_id FROM operadora \n"
                        + "			WHERE operadora.ope_numeracion=SUBSTRING('" + datos[vecComparacion].trim() + "',1,4) \n"
                        + "			AND SUBSTRING('" + datos[vecComparacion].trim() + "',5,10) BETWEEN operadora.ope_serie_inicio AND operadora.ope_serie_fin");
                while (rs.next()) {
                    datos[7] = rs.getString(1);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ModeloLlamada.class.getName()).log(Level.SEVERE, null, ex);
                ModeloLog ModeloLog = new ModeloLog();
                ModeloLog.escribirLog(String.valueOf(ex), "ModeloLlamada");
            } finally {
                this.cerrar();
            }

        }
        if (datos[7] == null || datos[7].equals("") || isNotNumeric(datos[7])) {

            datos[7] = "1";

        }
    }

    public static void moverArchivo(String ruta) {
        try {

            Process proceso = Runtime.getRuntime().exec("cmd /c move \"" + ruta + "\" \"C:\\LoctelCineto\\Backup\"");

        } catch (IOException e) {
            Logger.getLogger(ModeloLlamada.class.getName()).log(Level.SEVERE, null, e);
            ModeloLog ModeloLog = new ModeloLog();
            ModeloLog.escribirLog(String.valueOf(e), "ModeloLlamada");
        }
    }
}
