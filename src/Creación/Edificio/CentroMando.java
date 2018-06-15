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
public class CentroMando implements Edificio {

    private int vida = 1000;
    private int nivel = 1;
    private ArrayList<Recurso> recursos = new ArrayList<Recurso>();
    private String nombre = "centro";
    private ArrayList<Milicia> ataque = new ArrayList<>();
    private ArrayList<Milicia> atacando = new ArrayList<>();

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

    @Override
    public boolean TiempoConstruccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RestarRecurso(int cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Recurso getRecursoM() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addMilicia(Milicia milicia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getStats() {
        return "Centro de mando(Vida: " + vida + ")";
    }

    @Override
    public ArrayList<Milicia> getUnidades() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAtacante(Milicia milicia) {
        ataque.add(milicia);
    }

    @Override
    public ArrayList<Milicia> getAtacantes() {
        return ataque;
    }

    @Override
    public void addAtacando(Milicia milicia) {
        atacando.add(milicia);
    }

    @Override
    public ArrayList<Milicia> getAtacantesON() {
        return atacando;
    }

    @Override
    public int getVida() {
        return vida;
    }

    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public void autodefensa() {
        Milicia mili = null;
        for (Milicia m : this.atacando) {
            if (m.getVida() > 0) {
                m.restarVida(75);
            } else {
                mili = m;
            }

        }
        if (mili != null) {
            this.atacando.remove(mili);
        }

    }

}
