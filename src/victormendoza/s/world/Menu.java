/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victormendoza.s.world;

import Creación.AbstractEdificationFactory;
import Creación.EdificationProducer;
import Creación.Milicia.Milicia;
import java.util.Scanner;

/**
 *
 * @author victor
 */
public class Menu {
    private static Menu menu;
    
    private Menu(){}
    
    public static Menu getInstance(){
        if(menu == null){
            menu = new Menu();
            return menu;
        }else{
            return menu;
        }
        
    }
    
    public void MenuPrueba(){
        Scanner input = new Scanner(System.in);
        String cosa,raza;
        System.out.println("Escriba que desea generar:");
        cosa = input.nextLine();
        System.out.println("Escriba la raza:");
        raza = input.nextLine();
        
        AbstractEdificationFactory factory;
        
        factory = EdificationProducer.getFactory(cosa);
        Milicia mili = factory.getMilicia(raza);
        mili.Atacar();
        System.out.println(mili.getAtaque());
    }
}
