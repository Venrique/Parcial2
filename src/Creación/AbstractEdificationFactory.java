/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación;

import Creación.Edificio.Edificio;
import Creación.Milicia.Milicia;

/**
 *
 * @author victor
 */
public interface AbstractEdificationFactory {
    Milicia getMilicia(String tipo,String tropa);
    Edificio getEdificio(String tipo);
}
