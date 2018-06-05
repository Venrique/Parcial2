/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Milicia;

import Creación.AbstractEdificationFactory;

/**
 *
 * @author victor
 */
public class FactoryMilicia implements AbstractEdificationFactory {

    @Override
    public Milicia getMilicia(String tipo) {
        switch (tipo){
            case "EH":
                //vida,turnos,ataque
                return new Escuadron(300,2,75);
            case "EA":
                return new Escuadron(200,2,125);
            case "ER":
                return new Escuadron(300,1,75);
        }
        return null;
    }
    
}
