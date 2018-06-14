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
import java.util.InputMismatchException;
import java.util.Scanner;

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
                        break;
                    case 2:
                        bandera = 1;
                        MenuEdificacion(jugador);
                        break;
                    case 3:
                        int bandera2 = 5;
                        if (jugador == 0) {
                            for (Edificio e : ini.p1.getEdificiosC()) {
                                if(e.getNombre().equals("EscuelaM")){
                                    bandera2=-1;
                                }
                            }
                            if(bandera2==5){
                                System.out.println("Error: Debe crear una escuela militar primero.");
                            }else{
                                bandera=1;
                                MenuTropas(jugador);
                            }
                        }

                        break;
                    case 4:
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
            }
        }
    }

    public void MenuPrueba() {
        Scanner input = new Scanner(System.in);
        String cosa, raza;
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
                System.out.println("5. Fabrica de vehiculos. Costo: " + precios.getPrecioS("FabricaVehiculo"));
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
                            System.err.println("No tiene suficientes recursos para construir la edificación");
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
                            System.err.println("No tiene suficientes recursos para construir la edificación");
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
                            System.err.println("No tiene suficientes recursos para construir la edificación");
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
                            System.err.println("No tiene suficientes recursos para construir la edificación");
                        }
                        break;
                    case 5:
                        break;
                    case 6:
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
                                Milicia escuadron = factory.getMilicia(ini.p1.getRaza());
                                for(Edificio e : ini.p1.getEdificiosC()){
                                    if(e.getNombre().equals("EscuelaM")){
                                        
                                    }
                                }
                            } else {
                                ini.p2.addEdificio(escuela);
                            }
                        } else {
                            System.err.println("No tiene suficientes recursos para construir la edificación");
                        }
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                       
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

}
