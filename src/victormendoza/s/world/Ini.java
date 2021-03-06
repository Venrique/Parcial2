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
    public int contador = 0;
    public int ids = 0;

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
        System.out.println("3. Robot: Construcción más rápida pero menos daño.");
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
            recursosH.getListaRecurso().get(1).addCantidad(200);
            recursosH.getListaRecurso().get(2).addCantidad(50);
            p1.getEdificiosC().get(0).GuardarRecurso(recursosH.getListaRecurso());

        } else if (p1.getRaza() == "alien") {
            PaqueteRecursos recursosA = recursoBuilder.recursosAlien();
            recursosA.getListaRecurso().get(0).addCantidad(500);
            recursosA.getListaRecurso().get(1).addCantidad(200);
            recursosA.getListaRecurso().get(2).addCantidad(50);
            p1.getEdificiosC().get(0).GuardarRecurso(recursosA.getListaRecurso());
        } else {
            PaqueteRecursos recursosR = recursoBuilder.recursosRobot();
            recursosR.getListaRecurso().get(0).addCantidad(500);
            recursosR.getListaRecurso().get(1).addCantidad(200);
            recursosR.getListaRecurso().get(2).addCantidad(50);
            p1.getEdificiosC().get(0).GuardarRecurso(recursosR.getListaRecurso());
        }

        if (p2.getRaza() == "humano") {
            PaqueteRecursos recursosH = recursoBuilder.recursosHumanos();
            recursosH.getListaRecurso().get(0).addCantidad(500);
            recursosH.getListaRecurso().get(1).addCantidad(200);
            recursosH.getListaRecurso().get(2).addCantidad(50);
            p2.getEdificiosC().get(0).GuardarRecurso(recursosH.getListaRecurso());

        } else if (p2.getRaza() == "alien") {
            PaqueteRecursos recursosA = recursoBuilder.recursosAlien();
            recursosA.getListaRecurso().get(0).addCantidad(500);
            recursosA.getListaRecurso().get(1).addCantidad(200);
            recursosA.getListaRecurso().get(2).addCantidad(50);
            p2.getEdificiosC().get(0).GuardarRecurso(recursosA.getListaRecurso());
        } else {
            PaqueteRecursos recursosR = recursoBuilder.recursosRobot();
            recursosR.getListaRecurso().get(0).addCantidad(500);
            recursosR.getListaRecurso().get(1).addCantidad(200);
            recursosR.getListaRecurso().get(2).addCantidad(50);
            p2.getEdificiosC().get(0).GuardarRecurso(recursosR.getListaRecurso());
        }

        Juego();
    }

    private void Juego() {
        byte bandera = 0;
        Scanner input = new Scanner(System.in);
        ArrayList<Edificio> found = new ArrayList<Edificio>();

        while (p1.getCantEdificiosC() != 0 && p2.getCantEdificiosC() != 0) {
            System.out.println("\n.\n.\n.\n|| FASE #" + contador + " ||");

            if (bandera == 0) {
                System.out.println("Recurso 1:"+ini.p1.getEdificiosC().get(0).getRecursos().get(0).getCantidad());
                System.out.println("Recurso 2:"+ini.p1.getEdificiosC().get(0).getRecursos().get(1).getCantidad());
                System.out.println("Recurso 3:"+ini.p1.getEdificiosC().get(0).getRecursos().get(2).getCantidad());
                for (Edificio i : ini.p1.getEdificios()) {

                    if (i.TiempoConstruccion()) {
                        System.out.println(i.getNombre() + " ha terminado de construirse.");
                        ini.p1.addEdificioC(i);

                    }

                }

                for (Edificio e : ini.p1.getEdificiosC()) {

                    for (Milicia m : e.getAtacantes()) {

                        if (m.TiempoAtacar()) {
                            System.out.println(m.getNombre() + " está ahora atacando a " + e.getNombre());
                            e.addAtacando(m);

                        }
                    }

                    if (e.getVida() <= 0) {
                        found.add(e);
                    }

                    for (Milicia m : e.getAtacantesON()) {
                        m.Atacar(e, bandera);
                    }
                    e.Generar();
                    e.autodefensa();
                }

                ini.p1.getEdificiosC().removeAll(found);

            } else {
                System.out.println("Recurso 1:"+ini.p2.getEdificiosC().get(0).getRecursos().get(0).getCantidad());
                System.out.println("Recurso 2:"+ini.p2.getEdificiosC().get(0).getRecursos().get(1).getCantidad());
                System.out.println("Recurso 3:"+ini.p2.getEdificiosC().get(0).getRecursos().get(2).getCantidad());
                for (Edificio i : ini.p2.getEdificios()) {
                    if (i.TiempoConstruccion()) {
                        System.out.println(i.getNombre() + " ha terminado de construirse.");
                        ini.p2.addEdificioC(i);

                    }

                }

                for (Edificio e : ini.p2.getEdificiosC()) {
                    for (Milicia m : e.getAtacantes()) {
                        if (m.TiempoAtacar()) {
                            System.out.println(m.getNombre() + " está ahora atacando a " + e.getNombre());
                            e.addAtacando(m);

                        }
                    }

                    if (e.getVida() <= 0) {
                        found.add(e);
                    }

                    for (Milicia m : e.getAtacantesON()) {
                        m.Atacar(e, bandera);
                    }
                    e.Generar();
                    e.autodefensa();
                }
                ini.p2.getEdificiosC().removeAll(found);
            }

            System.out.println("\nTurno del jugador " + (bandera + 1));
            Menu menu = Menu.getInstance();
            menu.MenuPrincipal(bandera);

            if (bandera == 0) {
                bandera = 1;
            } else {
                bandera = 0;
            }
            found.removeAll(found);
            contador++;

        }
    }
}
