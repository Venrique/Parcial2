/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Edificio;

import Creación.AbstractEdificationFactory;
import Creación.Milicia.Milicia;

/**
 *
 * @author victor
 */
public class FactoryEdificio implements AbstractEdificationFactory{

    @Override
    public Milicia getMilicia(String tipo) {
        return null;
    }

    @Override
    public Edificio getEdificio(String tipo) {
        switch (tipo){
            case "centro":
                return new CentroMando();
                
        }
        return null;
    }
    
}
