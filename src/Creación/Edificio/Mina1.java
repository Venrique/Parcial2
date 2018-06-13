/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Edificio;

import Creación.Recursos.R1A_Paladio;
import Creación.Recursos.R1H_Madera;
import Creación.Recursos.R1R_Transistor;
import Creación.Recursos.Recurso;
import Creación.Recursos.Recursos;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class Mina1 implements Edificio {

    private Recursos recurso;
    private int uso = -1;
    private String nombre="Mina1";

    @Override
    public void Generar() {

        recurso.addCantidad(50);
        System.out.println("Recurso1: "+recurso.getCantidad());
    }

    @Override
    public void GuardarRecurso(ArrayList<Recurso> recurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Recurso> getRecursos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AsignarRecurso(String raza) {
        if (raza == "humano") {
            this.recurso = new R1H_Madera();
        } else if (raza == "alien") {
            this.recurso = new R1A_Paladio();
        } else {
            this.recurso = new R1R_Transistor();
        }
    }

    @Override
    public boolean TiempoConstruccion() {
        if(uso==0){
            uso+=1;
            return true;
        }else{
            uso+=1;
            return false;
        }
    }

    @Override
    public void RestarRecurso(int cantidad) {
        recurso.restar(cantidad);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Recurso getRecursoM() {
        return recurso;
    }

}
