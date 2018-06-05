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
public class init {

    public void Iniciar() {
        Jugador p1 = new Jugador();
        Jugador p2 = new Jugador();

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
    }
}
