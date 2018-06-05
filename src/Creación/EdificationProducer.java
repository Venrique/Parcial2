/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación;

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
        }
        return null;
    }
    
}
