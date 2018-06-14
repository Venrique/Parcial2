/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Milicia;

/**
 *
 * @author victor
 */
public class Escuadron implements Milicia {
   
    private int vida;
    private int turnos;
    private int ataque;
    
    
    public Escuadron(){}
    
    public Escuadron(int vida,int turnos,int ataque){
        this.vida = vida;
        this.turnos = turnos;
        this.ataque = ataque;
        
    }
    
    @Override
    public void Atacar() {
        System.out.println("Attacks");
    }
    
    @Override
    public int getAtaque(){
        return ataque;
    }
    
    public boolean isAlive(){
        if(vida>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean TiempoEntrenar() {
        if(turnos==0){
            turnos+=1;
            System.out.println(turnos);
            return true;
        }else{
            turnos+=1;
            return false;
        }
    }
    
}
