/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victormendoza.s.world;

import Creación.AbstractEdificationFactory;
import Creación.EdificationProducer;
import Creación.Edificio.Edificio;
import Creación.Milicia.Milicia;
import java.util.Scanner;

/**
 *
 * @author victor
 */
public class Ini {
    public static Jugador p1 = new Jugador();
    public static Jugador p2 = new Jugador();
    public static int turnos=0;
    
    private static Ini ini;
    
    private Ini(){}
    
    public static Ini getInstance(){
        if(ini == null){
            ini = new Ini();
            return ini;
        }else{
            return ini;
        }
        
    }

    public void Iniciar() {
        

        Scanner input = new Scanner(System.in);

        System.out.println("♦•♦ JUEGO INICIADO ♦•♦");
        System.out.println("\n •RAZAS•");
        System.out.println("1. Humano: Stats normales.");
        System.out.println("2. Alien: Más daño pero menos vida.");
        System.out.println("3. Robot: Unidades más rápidas. ");
        System.out.println("\n Jugador 1 escoja su raza:");
        p1.setRaza(input.nextInt());
        System.out.println("\n Jugador 2 escoja su raza:");
        p2.setRaza(input.nextInt());
        
        AbstractEdificationFactory factory;
        
        factory = EdificationProducer.getFactory("edificio");
        Edificio centro_p1 = factory.getEdificio("centro");
        Edificio centro_p2 = factory.getEdificio("centro");
        
        p1.addEdificio(centro_p1);
        p2.addEdificio(centro_p2);
        
        Juego();
    }
    
    private void Juego(){
        int bandera = 0;
        Scanner input = new Scanner(System.in);
        
        while(p1.getCantEdificios()!=0 && p2.getCantEdificios()!=0){
            
        }
    }
}