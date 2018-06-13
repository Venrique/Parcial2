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
public abstract class Recursos implements Recurso {
    
    public String nombre;
    public int cantidad=0;
    public int multiplicador=0;
    
    @Override
    public String getNombre(){
        return nombre;
    };

    @Override
    public int getCantidad(){
        return cantidad;
    };

    @Override
    public int getMultiplicador(){
        return multiplicador;
    };
    
    @Override
    public void addCantidad(int cantidad){
        
        this.cantidad=this.cantidad+cantidad;
        
    };

    @Override
    public void addMultiplicador(int multi){
        this.multiplicador=this.multiplicador+multi;
    };
    
    @Override
    public void restar(int cantidad){
        this.cantidad=this.cantidad-cantidad;
    };
}
