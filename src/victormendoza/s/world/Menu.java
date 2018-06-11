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

        while (bandera==0) {
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
                
                switch (opcion){
                    case 1:
                        break;
                    case 2:
                        bandera=1;
                        MenuEdificacion(jugador);
                        break;
                    case 3:
                        ini.p1.getEdificios().remove(0);
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6: 
                        bandera=1;
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

        while (bandera==0) {
            try {
                System.out.println("\n¿Qué edificación desea construir?");
                System.out.println("1. Mina de recurso 1. Costo: "+precios.getPrecioS("MinaR1"));
                System.out.println("2. Mina de recurso 2. Costo: "+precios.getPrecioS("MinaR2"));
                System.out.println("3. Mina de recurso 3. Costo: "+precios.getPrecioS("MinaR3"));
                System.out.println("4. Escuela militar. Costo: "+precios.getPrecioS("CampoEntrenamiento"));
                System.out.println("5. Fabrica de vehiculos. Costo: "+precios.getPrecioS("FabricaVehiculo"));
                System.out.println("6. Regresar.");
                System.out.print("--Seleccione una opción: ");
                opcion = input.nextInt();
                
                switch (opcion){
                    case 1:
                        if(val.ValidarRecursos(jugador,"MinaR1")){
                            factory = EdificationProducer.getFactory("edificio");
                            Edificio mina1 = factory.getEdificio("MinaR1");
                            if(jugador==0){
                                ini.p1.addEdificio(mina1);
                            }else{
                                ini.p2.addEdificio(mina1);
                            }
                        }else{
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
                        break;
                    case 6: 
                        bandera=1;
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
