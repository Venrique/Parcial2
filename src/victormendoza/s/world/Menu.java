/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victormendoza.s.world;

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
        }else{
            return menu;
        }
        return null;
    }
}
