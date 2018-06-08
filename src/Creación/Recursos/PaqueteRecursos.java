/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Recursos;
import java.util.ArrayList;
/**
 *
 * @author victor
 */
public class PaqueteRecursos {
    private ArrayList<Recurso> recursos = new ArrayList<Recurso>();
    
    public void addRecurso(Recurso recurso){
        recursos.add(recurso);
    }
    
    public ArrayList<Recurso> getListaRecurso(){
        return recursos;
    }
}
