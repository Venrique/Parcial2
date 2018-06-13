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
import Creación.Recursos.PaqueteRecursos;
import Creación.Recursos.RecursoBuilder;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author victor
 */
public class Ini {

    public Jugador p1 = new Jugador();
    public Jugador p2 = new Jugador();
    public int turnos = 0;

    private static Ini ini;

    private Ini() {
    }

    public static Ini getInstance() {
        if (ini == null) {
            ini = new Ini();
            return ini;
        } else {
            return ini;
        }

    }

    public void Iniciar() {

        Scanner input = new Scanner(System.in);

        System.out.println("♦•♦ JUEGO INICIADO ♦•♦");
        System.out.println("\n•RAZAS•");
        System.out.println("1. Humano: Stats normales.");
        System.out.println("2. Alien: Más daño pero menos vida.");
        System.out.println("3. Robot: Unidades más rápidas. ");
        System.out.println("\nJugador 1 escoja su raza:");
        p1.setRaza(input.nextInt());
        System.out.println("\nJugador 2 escoja su raza:");
        p2.setRaza(input.nextInt());

        //SE CREAN LOS CENTROS DE MANDO PARA CADA JUGADOR
        AbstractEdificationFactory factory;

        factory = EdificationProducer.getFactory("edificio");
        Edificio centro_p1 = factory.getEdificio("centro");
        Edificio centro_p2 = factory.getEdificio("centro");

        p1.addEdificioC(centro_p1);
        p2.addEdificioC(centro_p2);

        //SE AÑADEN LOS RECURSOS INICIALES A CADA JUGADOR DEPENDIENDO DE SU RAZA
        RecursoBuilder recursoBuilder = new RecursoBuilder();

        if (p1.getRaza() == "humano") {
            PaqueteRecursos recursosH = recursoBuilder.recursosHumanos();
            recursosH.getListaRecurso().get(0).addCantidad(500);
            recursosH.getListaRecurso().get(1).addCantidad(150);
            recursosH.getListaRecurso().get(2).addCantidad(50);
            p1.getEdificiosC().get(0).GuardarRecurso(recursosH.getListaRecurso());

        } else if (p1.getRaza() == "alien") {
            PaqueteRecursos recursosA = recursoBuilder.recursosAlien();
            recursosA.getListaRecurso().get(0).addCantidad(500);
            recursosA.getListaRecurso().get(1).addCantidad(150);
            recursosA.getListaRecurso().get(2).addCantidad(50);
            p1.getEdificiosC().get(0).GuardarRecurso(recursosA.getListaRecurso());
        } else {
            PaqueteRecursos recursosR = recursoBuilder.recursosRobot();
            recursosR.getListaRecurso().get(0).addCantidad(500);
            recursosR.getListaRecurso().get(1).addCantidad(150);
            recursosR.getListaRecurso().get(2).addCantidad(50);
            p1.getEdificiosC().get(0).GuardarRecurso(recursosR.getListaRecurso());
        }

        if (p2.getRaza() == "humano") {
            PaqueteRecursos recursosH = recursoBuilder.recursosHumanos();
            recursosH.getListaRecurso().get(0).addCantidad(500);
            recursosH.getListaRecurso().get(1).addCantidad(150);
            recursosH.getListaRecurso().get(2).addCantidad(50);
            p2.getEdificiosC().get(0).GuardarRecurso(recursosH.getListaRecurso());

        } else if (p2.getRaza() == "alien") {
            PaqueteRecursos recursosA = recursoBuilder.recursosAlien();
            recursosA.getListaRecurso().get(0).addCantidad(500);
            recursosA.getListaRecurso().get(1).addCantidad(150);
            recursosA.getListaRecurso().get(2).addCantidad(50);
            p2.getEdificiosC().get(0).GuardarRecurso(recursosA.getListaRecurso());
        } else {
            PaqueteRecursos recursosR = recursoBuilder.recursosRobot();
            recursosR.getListaRecurso().get(0).addCantidad(500);
            recursosR.getListaRecurso().get(1).addCantidad(150);
            recursosR.getListaRecurso().get(2).addCantidad(50);
            p2.getEdificiosC().get(0).GuardarRecurso(recursosR.getListaRecurso());
        }

        Juego();
    }

    private void Juego() {
        byte bandera = 0;
        Scanner input = new Scanner(System.in);
        int contador = 0;

        while (p1.getCantEdificiosC() != 0 && p2.getCantEdificiosC() != 0) {
            System.out.println("\n.\n.\n.\n|| FASE #" + contador + " ||");

            if (bandera == 0) {
                System.out.println(ini.p1.getEdificiosC().get(0).getRecursos().get(0).getCantidad());
                System.out.println(ini.p1.getEdificiosC().get(0).getRecursos().get(1).getCantidad());
                System.out.println(ini.p1.getEdificiosC().get(0).getRecursos().get(2).getCantidad());
                for (Edificio i : ini.p1.getEdificios()) {
                    if (i.TiempoConstruccion()) {
                        ini.p1.addEdificioC(i);

                    }
                }

                for (Edificio e : ini.p1.getEdificiosC()) {
                    e.Generar();
                }
            } else {
                System.out.println(ini.p2.getEdificiosC().get(0).getRecursos().get(0).getCantidad());
                System.out.println(ini.p2.getEdificiosC().get(0).getRecursos().get(1).getCantidad());
                System.out.println(ini.p2.getEdificiosC().get(0).getRecursos().get(2).getCantidad());
                for (Edificio i : ini.p2.getEdificios()) {
                    i.Generar();
                    if (i.TiempoConstruccion()) {
                        ini.p2.addEdificioC(i);

                    }
                }

                for (Edificio e : ini.p2.getEdificiosC()) {
                    e.Generar();
                }
            }

            System.out.println("\nTurno del jugador " + (bandera + 1));
            Menu menu = Menu.getInstance();
            menu.MenuPrincipal(bandera);

            if (bandera == 0) {
                bandera = 1;
            } else {
                bandera = 0;
            }

            contador++;

        }
    }
}
