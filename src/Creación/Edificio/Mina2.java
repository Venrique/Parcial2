/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Edificio;

import Creación.Recursos.R2A_Oricalco;
import Creación.Recursos.R2H_Piedra;
import Creación.Recursos.R2R_Electricidad;
import Creación.Recursos.Recurso;
import Creación.Recursos.Recursos;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class Mina2 implements Edificio {
    
    private Recursos recurso;
    
    @Override
    public void Generar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        if(raza=="humano"){
            this.recurso = new R2H_Piedra();
        }else if(raza=="alien"){
            this.recurso = new R2A_Oricalco();
        }else{
            this.recurso = new R2R_Electricidad();
        }
    }


    
}
