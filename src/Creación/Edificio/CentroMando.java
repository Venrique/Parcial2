/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Edificio;
import Creación.Recursos.Recurso;
import java.util.ArrayList;
/**
 *
 * @author victor
 */
public class CentroMando implements Edificio {
    private int vida = 1000;
    private int nivel = 1;
    private ArrayList<Recurso> recursos = new ArrayList<Recurso>();
    
    @Override
    public void GuardarRecurso(ArrayList<Recurso> recurso) {
        this.recursos = recurso;
    }

    @Override
    public ArrayList<Recurso> getRecursos() {
        return recursos;
    }

    @Override
    public void Generar() {
    }

    @Override
    public void AsignarRecurso(String raza) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
