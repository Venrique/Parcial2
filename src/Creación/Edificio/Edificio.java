/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Edificio;

import Creación.Milicia.Milicia;
import Creación.Recursos.Recurso;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public interface Edificio {
    public void Generar();
    public void GuardarRecurso(ArrayList<Recurso> recurso);
    public ArrayList<Recurso> getRecursos();
    public Recurso getRecursoM();
    public void AsignarRecurso(String raza);
    public boolean TiempoConstruccion();
    public void RestarRecurso(int cantidad);
    public String getNombre();
    public void addMilicia(Milicia milicia);
}
