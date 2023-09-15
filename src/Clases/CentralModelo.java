/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author CINETO
 */
public class CentralModelo {

    private int idCentralModelo;
    private String nombreCentralModelo;
    private String tipoArchivoCentralModelo;
    private String separadorCentralModelo;
    private String rutaCentralModelo;
    private String formatoFechaCentralModelo;
    private String numeroProvinciaCentralModelo;
    private CentralCampo centralCampo;
    private CentralMarca centralMarca;

    public int getIdCentralModelo() {
        return idCentralModelo;
    }

    public void setIdCentralModelo(int idCentralModelo) {
        this.idCentralModelo = idCentralModelo;
    }

    public String getNombreCentralModelo() {
        return nombreCentralModelo;
    }

    public void setNombreCentralModelo(String nombreCentralModelo) {
        this.nombreCentralModelo = nombreCentralModelo;
    }

    public String getTipoArchivoCentralModelo() {
        return tipoArchivoCentralModelo;
    }

    public void setTipoArchivoCentralModelo(String tipoArchivoCentralModelo) {
        this.tipoArchivoCentralModelo = tipoArchivoCentralModelo;
    }

    public String getSeparadorCentralModelo() {
        return separadorCentralModelo;
    }

    public void setSeparadorCentralModelo(String separadorCentralModelo) {
        this.separadorCentralModelo = separadorCentralModelo;
    }

    public String getRutaCentralModelo() {
        return rutaCentralModelo;
    }

    public void setRutaCentralModelo(String rutaCentralModelo) {
        this.rutaCentralModelo = rutaCentralModelo;
    }

    public String getFormatoFechaCentralModelo() {
        return formatoFechaCentralModelo;
    }

    public void setFormatoFechaCentralModelo(String formatoFechaCentralModelo) {
        this.formatoFechaCentralModelo = formatoFechaCentralModelo;
    }

    public String getNumeroProvinciaCentralModelo() {
        return numeroProvinciaCentralModelo;
    }

    public void setNumeroProvinciaCentralModelo(String numeroProvinciaCentralModelo) {
        this.numeroProvinciaCentralModelo = numeroProvinciaCentralModelo;
    }

    public CentralCampo getCentralCampo() {
        return centralCampo;
    }

    public void setCentralCampo(CentralCampo centralCampo) {
        this.centralCampo = centralCampo;
    }

    public CentralMarca getCentralMarca() {
        return centralMarca;
    }

    public void setCentralMarca(CentralMarca centralMarca) {
        this.centralMarca = centralMarca;
    }
    
}
