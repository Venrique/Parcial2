/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Edificio;

import Creación.Milicia.Milicia;
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

    private int vida = 400;
    private Recursos recurso;
    private int uso = -1;
    private String nombre = "Mina2";
    private ArrayList<Milicia> ataque = new ArrayList<>();
    private ArrayList<Milicia> atacando = new ArrayList<>();

    @Override
    public void Generar() {
        recurso.addCantidad(100);
        System.out.println("Mina 2: " + recurso.getCantidad());
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
            this.recurso = new R2H_Piedra();
        } else if (raza == "alien") {
            this.recurso = new R2A_Oricalco();
        } else {
            this.recurso = new R2R_Electricidad();
        }
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

    @Override
    public void addMilicia(Milicia milicia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getStats() {
        return "Mina de recurso 2(Vida: " + vida + ")";
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
        this.vida=vida;
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
