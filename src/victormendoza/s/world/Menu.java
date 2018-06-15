/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victormendoza.s.world;

import Creación.AbstractEdificationFactory;
import Creación.EdificationProducer;
import Creación.Edificio.Edificio;
import Creación.Edificio.Mina1;
import Creación.Milicia.Milicia;
import static java.lang.Thread.sleep;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victor
 */
public class Menu {

    private static Menu menu;

    private Menu() {
    }

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
            return menu;
        } else {
            return menu;
        }

    }

    public void MenuPrincipal(byte jugador) {

        Scanner input = new Scanner(System.in);
        int opcion;
        byte bandera = 0;

        Ini ini = Ini.getInstance();

        while (bandera == 0) {
            try {
                System.out.println("\n¿Qué desea hacer?");
                System.out.println("1. Ver estadísticas de la partida.");
                System.out.println("2. Construir edificación.");
                System.out.println("3. Entrenar tropas.");
                System.out.println("4. Atacar/Defender.");
                System.out.println("5. Recoger recursos.");
                System.out.println("6. Pasar turno.");
                System.out.print("--Seleccione una opción: ");
                opcion = input.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\n\n- - - Jugador 1 - - -");
                        System.out.println("Edificaciones: ");
                        for (Edificio e : ini.p1.getEdificiosC()) {
                            System.out.println(e.getStats());
                        }
                        if (jugador == 0) {
                            System.out.println("Tropas:");
                            for (Edificio e : ini.p1.getEdificiosC()) {
                                if (e.getNombre().equals("EscuelaM")) {
                                    for (Milicia m : e.getUnidades()) {
                                        System.out.println(m.getNombre()+"(Vida: "+m.getVida()+")");
                                    }
                                }
                            }
                        }

                        System.out.println("\n- - - Jugador 2 - - -");
                        System.out.println("Edificaciones: ");
                        for (Edificio e : ini.p2.getEdificiosC()) {
                            System.out.println(e.getStats());
                        }
                        if (jugador == 1) {
                            System.out.println("Tropas:");
                            for (Edificio e : ini.p2.getEdificiosC()) {
                                if (e.getNombre().equals("EscuelaM")) {
                                    for (Milicia m : e.getUnidades()) {
                                        System.out.println(m.getNombre()+"(Vida: "+m.getVida()+")");
                                    }
                                }
                            }
                        }
                        sleep(3000);
                        break;
                    case 2:
                        bandera = 1;
                        MenuEdificacion(jugador);
                        break;
                    case 3:
                        int bandera2 = 5;
                        if (jugador == 0) {
                            for (Edificio e : ini.p1.getEdificiosC()) {
                                if (e.getNombre().equals("EscuelaM")) {
                                    bandera2 = -1;
                                }
                            }
                            if (bandera2 == 5) {
                                System.out.println("Error: Debe crear una escuela militar primero.");
                            } else {
                                bandera = 1;
                                MenuTropas(jugador);
                            }
                        } else {
                            for (Edificio e : ini.p2.getEdificiosC()) {
                                if (e.getNombre().equals("EscuelaM")) {
                                    bandera2 = -1;
                                }
                            }
                            if (bandera2 == 5) {
                                System.out.println("Error: Debe crear una escuela militar primero.");
                            } else {
                                bandera = 1;
                                MenuTropas(jugador);
                            }
                        }

                        break;
                    case 4:

                        if (jugador == 0) {
                            for (Edificio e : ini.p1.getEdificiosC()) {
                                if (e.getNombre().equals("EscuelaM")) {
                                    if (e.getUnidades().size() > 0) {
                                        bandera = 1;
                                        MenuAtacar(jugador);
                                        break;
                                    } else {
                                        System.out.println("Error: No tiene tropas con las que atacar.");
                                    }
                                }
                            }
                        } else {
                            for (Edificio e : ini.p2.getEdificiosC()) {
                                if (e.getNombre().equals("EscuelaM")) {
                                    if (e.getUnidades().size() > 0) {
                                        bandera = 1;
                                        MenuAtacar(jugador);
                                        break;
                                    } else {
                                        System.out.println("Error: No tiene tropas con las que atacar.");
                                    }
                                }
                            }
                        }
                        System.out.println("Error: No tiene tropas con las que atacar.");
                        break;
                    case 5:
                        if (jugador == 0) {
                            for (Edificio e : ini.p1.getEdificiosC()) {
                                if (e.getNombre().equals("Mina1")) {
                                    ini.p1.getEdificiosC().get(0).getRecursos().get(0).addCantidad(e.getRecursoM().getCantidad());
                                    e.RestarRecurso(e.getRecursoM().getCantidad());
                                } else if (e.getNombre().equals("Mina2")) {
                                    ini.p1.getEdificiosC().get(0).getRecursos().get(1).addCantidad(e.getRecursoM().getCantidad());
                                    e.RestarRecurso(e.getRecursoM().getCantidad());
                                }
                            }
                        } else {
                            for (Edificio e : ini.p2.getEdificiosC()) {
                                if (e.getNombre().equals("Mina1")) {
                                    ini.p2.getEdificiosC().get(0).getRecursos().get(0).addCantidad(e.getRecursoM().getCantidad());
                                    e.RestarRecurso(e.getRecursoM().getCantidad());
                                } else if (e.getNombre().equals("Mina2")) {
                                    ini.p2.getEdificiosC().get(0).getRecursos().get(1).addCantidad(e.getRecursoM().getCantidad());
                                    e.RestarRecurso(e.getRecursoM().getCantidad());
                                }
                            }
                        }
                        break;
                    case 6:
                        bandera = 1;
                        break;
                    default:
                        System.err.println("No seleccióno una opción válida. Intentelo de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.err.println("No seleccinó una opción válida. Intentelo de nuevo.");
            } catch (InterruptedException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void MenuEdificacion(byte jugador) {
        Scanner input = new Scanner(System.in);
        int opcion;
        byte bandera = 0;

        Precios precios = Precios.getInstace();
        Ini ini = Ini.getInstance();
        Validaciones val = Validaciones.getInstance();

        AbstractEdificationFactory factory;

        while (bandera == 0) {
            try {
                System.out.println("\n¿Qué edificación desea construir?");
                System.out.println("1. Mina de recurso 1. Costo: " + precios.getPrecioS("MinaR1"));
                System.out.println("2. Mina de recurso 2. Costo: " + precios.getPrecioS("MinaR2"));
                System.out.println("3. Mina de recurso 3. Costo: " + precios.getPrecioS("MinaR3"));
                System.out.println("4. Escuela militar. Costo: " + precios.getPrecioS("CampoEntrenamiento"));
                System.out.println("5. Mejorar Centro de mando.");
                System.out.println("6. Regresar.");
                System.out.print("--Seleccione una opción: ");
                opcion = input.nextInt();

                switch (opcion) {
                    case 1:
                        if (val.ValidarRecursos(jugador, "MinaR1")) {
                            factory = EdificationProducer.getFactory("edificio");
                            Edificio mina1 = factory.getEdificio("MinaR1");
                            if (jugador == 0) {
                                mina1.AsignarRecurso(ini.p1.getRaza());
                                ini.p1.addEdificio(mina1);

                            } else {
                                mina1.AsignarRecurso(ini.p2.getRaza());
                                ini.p2.addEdificio(mina1);
                            }
                        } else {
                            System.out.println("Error: no tiene suficientes recursos para construir la edificación");
                        }
                        break;
                    case 2:
                        if (val.ValidarRecursos(jugador, "MinaR2")) {
                            factory = EdificationProducer.getFactory("edificio");
                            Edificio mina2 = factory.getEdificio("MinaR2");
                            if (jugador == 0) {
                                mina2.AsignarRecurso(ini.p1.getRaza());
                                ini.p1.addEdificio(mina2);
                            } else {
                                mina2.AsignarRecurso(ini.p2.getRaza());
                                ini.p2.addEdificio(mina2);
                            }
                        } else {
                            System.out.println("Error: no tiene suficientes recursos para construir la edificación");
                        }
                        break;
                    case 3:
                        if (val.ValidarRecursos(jugador, "MinaR3")) {
                            factory = EdificationProducer.getFactory("edificio");
                            Edificio mina3 = factory.getEdificio("MinaR3");
                            if (jugador == 0) {
                                mina3.AsignarRecurso(ini.p1.getRaza());
                                ini.p1.addEdificio(mina3);
                            } else {
                                mina3.AsignarRecurso(ini.p2.getRaza());
                                ini.p2.addEdificio(mina3);
                            }
                        } else {
                            System.out.println("Error: no tiene suficientes recursos para construir la edificación");
                        }
                        break;
                    case 4:
                        if (val.ValidarRecursos(jugador, "CampoEntrenamiento")) {
                            factory = EdificationProducer.getFactory("edificio");
                            Edificio escuela = factory.getEdificio("CampoEntrenamiento");
                            if (jugador == 0) {
                                ini.p1.addEdificio(escuela);
                            } else {
                                ini.p2.addEdificio(escuela);
                            }
                        } else {
                            System.out.println("Error: no tiene suficientes recursos para construir la edificación");
                        }
                        break;
                    case 5:
                        break;
                    case 6:
                        bandera = 1;
                        break;
                    default:
                        System.out.println("Error: no seleccióno una opción válida. Intentelo de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: no seleccinó una opción válida. Intentelo de nuevo.");
            }
        }
        MenuPrincipal(jugador);
    }

    public void MenuTropas(byte jugador) {
        Scanner input = new Scanner(System.in);
        int opcion;
        byte bandera = 0;

        Precios precios = Precios.getInstace();
        Ini ini = Ini.getInstance();
        Validaciones val = Validaciones.getInstance();

        AbstractEdificationFactory factory;

        while (bandera == 0) {
            try {
                System.out.println("\n¿Qué tipo de tropas desea entrenar?");
                System.out.println("1. Escuadrón. Costo: " + precios.getPrecioS("Escuadron"));
                System.out.println("2. Soldado Especial. Costo: " + precios.getPrecioS("Especialista"));
                System.out.println("3. Vehículo básico. Costo: " + precios.getPrecioS("Vehiculo1"));
                System.out.println("4. Vehículo avanzado. Costo: " + precios.getPrecioS("Vehiculo2"));
                System.out.println("5. Regresar.");
                System.out.print("--Seleccione una opción: ");
                opcion = input.nextInt();

                switch (opcion) {
                    case 1:
                        if (val.ValidarRecursos(jugador, "Escuadron")) {
                            factory = EdificationProducer.getFactory("milicia");

                            if (jugador == 0) {
                                Milicia escuadron = factory.getMilicia(ini.p1.getRaza(), "Escuadron");
                                for (Edificio e : ini.p1.getEdificiosC()) {
                                    if (e.getNombre().equals("EscuelaM")) {
                                        ini.ids += 1;
                                        e.addMilicia(escuadron);
                                    }
                                }
                            } else {
                                Milicia escuadron = factory.getMilicia(ini.p2.getRaza(), "Escuadron");
                                for (Edificio e : ini.p2.getEdificiosC()) {
                                    if (e.getNombre().equals("EscuelaM")) {
                                        ini.ids += 1;
                                        e.addMilicia(escuadron);
                                    }
                                }
                            }
                        } else {
                            System.err.println("No tiene suficientes recursos para construir el escuadrón");
                        }
                        break;
                    case 2:
                        if (val.ValidarRecursos(jugador, "Especialista")) {
                            factory = EdificationProducer.getFactory("milicia");

                            if (jugador == 0) {
                                Milicia especialista = factory.getMilicia(ini.p1.getRaza(), "Especialista");
                                for (Edificio e : ini.p1.getEdificiosC()) {
                                    if (e.getNombre().equals("EscuelaM")) {
                                        ini.ids += 1;
                                        e.addMilicia(especialista);
                                    }
                                }
                            } else {
                                Milicia especialista = factory.getMilicia(ini.p2.getRaza(), "Especialista");
                                for (Edificio e : ini.p2.getEdificiosC()) {
                                    if (e.getNombre().equals("EscuelaM")) {
                                        ini.ids += 1;
                                        e.addMilicia(especialista);
                                    }
                                }
                            }
                        } else {
                            System.err.println("No tiene suficientes recursos para construir el especialista");
                        }
                        break;
                    case 3:
                        if (val.ValidarRecursos(jugador, "Vehiculo1")) {
                            factory = EdificationProducer.getFactory("milicia");

                            if (jugador == 0) {
                                Milicia vehiculo1 = factory.getMilicia(ini.p1.getRaza(), "Vehiculo1");
                                for (Edificio e : ini.p1.getEdificiosC()) {
                                    if (e.getNombre().equals("EscuelaM")) {
                                        ini.ids += 1;
                                        e.addMilicia(vehiculo1);
                                    }
                                }
                            } else {
                                Milicia vehiculo1 = factory.getMilicia(ini.p2.getRaza(), "Especialista");
                                for (Edificio e : ini.p2.getEdificiosC()) {
                                    if (e.getNombre().equals("EscuelaM")) {
                                        ini.ids += 1;
                                        e.addMilicia(vehiculo1);
                                    }
                                }
                            }
                        } else {
                            System.err.println("No tiene suficientes recursos para construir el vehículo");
                        }
                        break;
                    case 4:
                        if (val.ValidarRecursos(jugador, "Vehiculo2")) {
                            factory = EdificationProducer.getFactory("milicia");

                            if (jugador == 0) {
                                Milicia vehiculo2 = factory.getMilicia(ini.p1.getRaza(), "Vehiculo2");
                                for (Edificio e : ini.p1.getEdificiosC()) {
                                    if (e.getNombre().equals("EscuelaM")) {
                                        ini.ids += 1;
                                        e.addMilicia(vehiculo2);
                                    }
                                }
                            } else {
                                Milicia vehiculo2 = factory.getMilicia(ini.p2.getRaza(), "Especialista");
                                for (Edificio e : ini.p2.getEdificiosC()) {
                                    if (e.getNombre().equals("EscuelaM")) {
                                        ini.ids += 1;
                                        e.addMilicia(vehiculo2);
                                    }
                                }
                            }
                        } else {
                            System.err.println("No tiene suficientes recursos para construir el vehículo");
                        }
                        break;
                    case 5:
                        bandera = 1;
                        break;
                    default:
                        System.err.println("No seleccióno una opción válida. Intentelo de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.err.println("No seleccinó una opción válida. Intentelo de nuevo.");
            }
        }
        MenuPrincipal(jugador);
    }

    private void MenuAtacar(byte jugador) {
        Scanner input = new Scanner(System.in);
        String tropa, ataque;
        int opcion;
        byte bandera = 0;

        Precios precios = Precios.getInstace();
        Ini ini = Ini.getInstance();
        Validaciones val = Validaciones.getInstance();

        AbstractEdificationFactory factory;

        while (bandera == 0) {
            try {

                System.out.println("\n¿Qué desea hacer?");
                System.out.println("1. Atacar.");
                System.out.println("2. Defender.");
                System.out.println("3. Regresar.");
                opcion = input.nextInt();
                input.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("\n¿Con qué tropa desea atacar?");
                        if (jugador == 0) {

                            for (Edificio e : ini.p1.getEdificiosC()) {
                                if (e.getNombre().equals("EscuelaM")) {
                                    for (Milicia m : e.getUnidades()) {
                                        System.out.print(m.getNombre() + " - ");
                                    }
                                }
                            }
                        } else {
                            for (Edificio e : ini.p2.getEdificiosC()) {
                                if (e.getNombre().equals("EscuelaM")) {
                                    for (Milicia m : e.getUnidades()) {
                                        System.out.print(m.getNombre() + " - ");
                                    }
                                }
                            }
                        }
                        System.out.println("");
                        tropa = input.nextLine().trim();
                        System.out.println("\n ¿A qué edificación enemiga desea atacar?");
                        if (jugador == 0) {
                            for (Edificio e : ini.p2.getEdificiosC()) {
                                System.out.println(e.getNombre());
                            }
                        } else {
                            for (Edificio e : ini.p1.getEdificiosC()) {
                                System.out.println(e.getNombre());
                            }
                        }
                        System.out.println("");
                        ataque = input.nextLine().trim();

                        System.out.println(tropa + " " + ataque);

                        if (jugador == 0) {
                            for (Edificio e : ini.p2.getEdificiosC()) {
                                if (e.getNombre().equals(ataque)) {
                                    for (Edificio e2 : ini.p1.getEdificiosC()) {
                                        if (e2.getNombre().equals("EscuelaM")) {

                                            for (Milicia m : e2.getUnidades()) {
                                                if (m.getNombre().equals(tropa)) {

                                                    e.addAtacante(m);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            for (Edificio e : ini.p1.getEdificiosC()) {
                                if (e.getNombre().equals(ataque)) {
                                    for (Edificio e2 : ini.p2.getEdificiosC()) {
                                        if (e2.getNombre().equals("EscuelaM")) {
                                            for (Milicia m : e2.getUnidades()) {
                                                if (m.getNombre().equals(tropa)) {
                                                    e.addAtacante(m);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        break;
                    case 2:
                        System.out.println("\n¿Con qué tropa desea atacar?");
                        if (jugador == 0) {

                            for (Edificio e : ini.p1.getEdificiosC()) {
                                if (e.getNombre().equals("EscuelaM")) {
                                    for (Milicia m : e.getUnidades()) {
                                        System.out.print(m.getNombre() + " - ");
                                    }
                                }
                            }
                        } else {
                            for (Edificio e : ini.p2.getEdificiosC()) {
                                if (e.getNombre().equals("EscuelaM")) {
                                    for (Milicia m : e.getUnidades()) {
                                        System.out.print(m.getNombre() + " - ");
                                    }
                                }
                            }
                        }
                        System.out.println("");
                        tropa = input.nextLine();
                        System.out.println("\n ¿A qué tropa enemiga desea atacar?");
                        if (jugador == 0) {
                            for (Edificio e : ini.p2.getEdificiosC()) {
                                if (e.getNombre().equals("EscuelaM")) {
                                    for (Milicia m : e.getUnidades()) {
                                        System.out.print(m.getNombre() + " - ");
                                    }
                                }
                            }
                        } else {
                            for (Edificio e : ini.p1.getEdificiosC()) {
                                if (e.getNombre().equals("EscuelaM")) {
                                    for (Milicia m : e.getUnidades()) {
                                        System.out.print(m.getNombre() + " - ");
                                    }
                                }
                            }
                        }
                        System.out.println("");
                        ataque = input.nextLine();
                        
                        
                        break;
                    case 3:
                        bandera = 1;
                        break;
                    default:
                        System.out.println("No seleccionó una opción válida. Intentelo de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.err.println("No seleccinó una opción válida. Intentelo de nuevo.");
            }
        }
        MenuPrincipal(jugador);
    }

}
