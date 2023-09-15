/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Types;

/**
 *
 * @author mayra
 */
public class Parametros {

    public String nombre;
    public Object valor;
    public Types tipoDato;
    public int tamaño;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Types getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(Types tipoDato) {
        this.tipoDato = tipoDato;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public Parametros(String nombre, Object valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

}
