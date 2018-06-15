/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Milicia;

import Creación.AbstractEdificationFactory;
import Creación.Edificio.Edificio;
import victormendoza.s.world.Ini;

/**
 *
 * @author victor
 */
public class FactoryMilicia implements AbstractEdificationFactory {

    @Override
    public Milicia getMilicia(String tipo, String tropa) {

        Ini ini = Ini.getInstance();

        switch (tipo) {
            case "humano":
                //vida,turnos,ataque
                if (tropa.equals("Escuadron")) {
                    return new Escuadron(300, -1, 75, "Escuadron" + ini.ids,-1);
                } else if (tropa.equals("Especialista")) {
                    return new Escuadron(100, -1, 200, "Especialista" + ini.ids,-1);
                } else if (tropa.equals("Vehiculo1")) {
                    return new Escuadron(1000, -2, 100, "Tanque M1 Abrams" + ini.ids,-2);
                } else if (tropa.equals("Vehiculo2")) {
                    return new Escuadron(800, -3, 200, "Helicoptero Apache" + ini.ids,-1);
                }

            case "alien":
                if (tropa.equals("Escuadron")) {
                    return new Escuadron(200, -1, 125, "Alienigena" + ini.ids,-1);
                } else if (tropa.equals("Especialista")) {
                    return new Escuadron(75, -1, 300, "Criatura del vácio" + ini.ids,-1);
                } else if (tropa.equals("Vehiculo1")) {
                    return new Escuadron(900, -2, 200, "OVNI" + ini.ids,-2);
                } else if (tropa.equals("Vehiculo2")) {
                    return new Escuadron(700, -3, 300, "Mothership" + ini.ids,-1);
                }
            case "robot":
                if (tropa.equals("Escuadron")) {
                    return new Escuadron(300, -1, 75, "Cyborg" + ini.ids,-1);
                } else if (tropa.equals("Especialista")) {
                    return new Escuadron(100, -1, 200, "Terminator" + ini.ids,-1);
                } else if (tropa.equals("Vehiculo1")) {
                    return new Escuadron(500, -1, 75, "Optimus Prime",-2);
                } else if (tropa.equals("Vehiculo2")) {
                    return new Escuadron(800, -2, 125, "EVA 01",-1);
                }
        }
        return null;
    }

    @Override

    public Edificio getEdificio(String tipo) {
        return null;
    }

}
