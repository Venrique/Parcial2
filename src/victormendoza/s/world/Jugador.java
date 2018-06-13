/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victormendoza.s.world;

import Creación.Edificio.Edificio;
import Creación.Milicia.Milicia;
import Creación.Recursos.Recurso;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class Jugador {

    private String raza;
    private ArrayList<Milicia> unidades = new ArrayList<Milicia>();
    private ArrayList<Edificio> edificios = new ArrayList<Edificio>();
    
    private ArrayList<Milicia> unidadesC = new ArrayList<Milicia>();
    private ArrayList<Edificio> edificiosC = new ArrayList<Edificio>();

    public void setRaza(int raza) {
        switch (raza) {
            case 1:
                this.raza = "humano";
                break;
            case 2:
                this.raza = "alien";
                break;
            case 3:
                this.raza = "robot";
                break;
            default:
                System.out.println("No escribió una raza válida. Se selecciono humano por defecto.");
                this.raza = "humano";
                break;
        }

    }

    public String getRaza() {
        return raza;
    }

    public ArrayList<Edificio> getEdificios() {
        return edificios;
    }
    
    public ArrayList<Edificio> getEdificiosC() {
        return edificiosC;
    }

    public int getCantEdificios() {
        return edificios.size();
    }
    
    public int getCantEdificiosC() {
        return edificiosC.size();
    }


    public void addEdificio(Edificio edificio) {
        this.edificios.add(edificio);
    }
    
    public void addEdificioC(Edificio edificio) {
        this.edificiosC.add(edificio);
    }
    
    
}
