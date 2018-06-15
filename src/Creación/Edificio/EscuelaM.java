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
public class EscuelaM implements Edificio {

    private String nombre = "EscuelaM";
    private ArrayList<Milicia> unidadesC = new ArrayList<>();
    private ArrayList<Milicia> unidades = new ArrayList<>();
    private int uso = -1;
    private int vida = 500;
    private ArrayList<Milicia> ataque = new ArrayList<>();
    private ArrayList<Milicia> atacando = new ArrayList<>();

    @Override
    public void Generar() {
        for (Milicia m : unidades) {
            if (m.TiempoEntrenar()) {
                unidadesC.add(m);
            }
        }
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
    public void AsignarRecurso(String milicia) {

    }

    @Override
    public boolean TiempoConstruccion() {
        if (uso == 0) {
            uso += 1;
            return true;
        } else {
            uso += 1;
            return false;
        }
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
        unidades.add(milicia);
    }

    @Override
    public String getStats() {
        return "Escuela Militar(Vida: " + vida + ")";
    }

    @Override
    public ArrayList<Milicia> getUnidades() {
        return unidadesC;
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
