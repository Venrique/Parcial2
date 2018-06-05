/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victormendoza.s.world;

import Creación.Milicia.Milicia;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class Jugador {

    private String raza;
    private int recurso1, recurso2, recurso3;
    private ArrayList<Milicia> unidades;

    public String getRaza() {
        return raza;
    }

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

}
