/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Recursos;

/**
 *
 * @author victor
 */
public interface Recurso {
    public String getNombre();
    public int getCantidad();
    public int getMultiplicador();
    public void addCantidad(int cantidad);
    public void addMultiplicador(int multi);
}
