/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Edificio;

import Creación.Milicia.Milicia;
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

    private int vida = 500;
    private Recurso recurso;
    private int uso = -1;
    private String nombre = "Mina3";
    private ArrayList<Milicia> ataque = new ArrayList<>();
    private ArrayList<Milicia> atacando = new ArrayList<>();

    @Override
    public void Generar() {
        recurso.addCantidad(50);
        System.out.println("Recurso3: " + recurso.getCantidad());
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
        return "Mina de recurso 3(Vida: " + vida + ")";
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

}
