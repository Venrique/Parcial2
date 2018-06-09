/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Edificio;

import Creación.Recursos.Recurso;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public interface Edificio {
    public void GenerarRecurso();
    public void GenerarMilicia();
    public void GuardarRecurso(ArrayList<Recurso> recurso);
}
