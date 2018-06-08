/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Recursos;

/**
 *
 * @author victor
 */
public class RecursoBuilder {
    public PaqueteRecursos recursosHumanos(){
        PaqueteRecursos recursosH = new PaqueteRecursos();
        recursosH.addRecurso(new R1H_Madera());
        recursosH.addRecurso(new R2H_Piedra());
        recursosH.addRecurso(new R3H_Metal());
        
        return recursosH;
    }
    
    public PaqueteRecursos recursosAlien(){
        PaqueteRecursos recursosA = new PaqueteRecursos();
        recursosA.addRecurso(new R1A_Paladio());
        recursosA.addRecurso(new R2A_Oricalco());
        recursosA.addRecurso(new R3A_Adamantita());
        
        return recursosA;
    }
    
    public PaqueteRecursos recursosRobot(){
        PaqueteRecursos recursosR = new PaqueteRecursos();
        recursosR.addRecurso(new R1R_Transistor());
        recursosR.addRecurso(new R2R_Electricidad());
        recursosR.addRecurso(new R3R_Plasma());
        
        return recursosR;
    }
}
