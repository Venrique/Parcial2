/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación;

import Creación.Edificio.FactoryEdificio;
import Creación.Milicia.FactoryMilicia;

/**
 *
 * @author victor
 */
public class EdificationProducer {
    
    public static AbstractEdificationFactory getFactory(String tipo){
        switch (tipo){
            case "milicia":
                return new FactoryMilicia();
            case "edificio":
                return new FactoryEdificio();
        }
        return null;
    }
    
}
