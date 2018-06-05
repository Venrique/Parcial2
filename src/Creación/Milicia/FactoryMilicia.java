/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Milicia;

import Creación.AbstractEdificationFactory;
import Creación.Edificio.Edificio;

/**
 *
 * @author victor
 */
public class FactoryMilicia implements AbstractEdificationFactory {

    @Override
    public Milicia getMilicia(String tipo) {
        switch (tipo){
            case "humano":
                //vida,turnos,ataque
                return new Escuadron(300,2,75);
            case "alien":
                return new Escuadron(200,2,125);
            case "robot":
                return new Escuadron(300,1,75);
        }
        return null;
    }

    @Override
    
    public Edificio getEdificio(String tipo) {
        return null;
    }
    
}
