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
    public String getStats();
    public ArrayList<Milicia> getUnidades();
    public void addAtacante(Milicia milicia);
    public void addAtacando(Milicia milicia);;
    public ArrayList<Milicia> getAtacantes();
    public ArrayList<Milicia> getAtacantesON();
    public int getVida();
    public void setVida(int vida);
    public void autodefensa();
}
