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
    public Milicia getMilicia(String tipo,String tropa) {
        switch (tipo){
            case "humano":
                //vida,turnos,ataque
                if(tropa.equals("Escuadron")){
                    return new Escuadron(300,-1,75);
                }else if(tropa.equals("Especialista")){
                    return new Escuadron(100,-1,200);
                }else if(tropa.equals("Vehiculo1")){
                    return new Escuadron(500,-2,100);
                }else if(tropa.equals("Vehiculo2")){
                    return new Escuadron(800,-3,200);
                }
                
            case "alien":
                if(tropa.equals("Escuadron")){
                    return new Escuadron(200,-1,125);
                }else if(tropa.equals("Especialista")){
                    return new Escuadron(75,-1,300);
                }else if(tropa.equals("Vehiculo1")){
                    return new Escuadron(400,-2,200);
                }else if(tropa.equals("Vehiculo2")){
                    return new Escuadron(700,-3,300);
                }
            case "robot":
                if(tropa.equals("Escuadron")){
                    return new Escuadron(300,-1,75);
                }else if(tropa.equals("Especialista")){
                    return new Escuadron(100,-1,200);
                }else if(tropa.equals("Vehiculo1")){
                    return new Escuadron(500,-1,75);
                }else if(tropa.equals("Vehiculo2")){
                    return new Escuadron(800,-2,125);
                }
        }
        return null;
    }

    @Override
    
    public Edificio getEdificio(String tipo) {
        return null;
    }
    
}
