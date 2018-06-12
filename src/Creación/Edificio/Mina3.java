/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Edificio;

import Creación.Recursos.R3A_Adamantita;
import Creación.Recursos.R3H_Metal;
import Creación.Recursos.R3R_Plasma;
import Creación.Recursos.Recurso;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class Mina3 implements Edificio {

    private Recurso recurso;

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
        if (raza == "humano") {
            this.recurso = new R3H_Metal();
        } else if (raza == "alien") {
            this.recurso = new R3A_Adamantita();
        } else {
            this.recurso = new R3R_Plasma();
        }
    }

}
