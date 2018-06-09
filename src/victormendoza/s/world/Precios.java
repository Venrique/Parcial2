/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victormendoza.s.world;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author victor
 */
public class Precios {

    private static Precios precio;
    private Map<String, int[]> precios = new HashMap<String, int[]>();

    private Precios() {

        precios.put("MinaR1", new int[]{400, 50, 0});
        precios.put("MinaR2", new int[]{600, 100, 0});
        precios.put("MinaR3", new int[]{1200, 800, 0});
        precios.put("CampoEntrenamiento", new int[]{300, 100, 0});
        precios.put("FabricaVehiculo", new int[]{400, 400, 200});
        precios.put("Escuadron", new int[]{100, 100, 100});
        precios.put("Especialista", new int[]{50, 800, 500});
        precios.put("Vehiculo1", new int[]{1000, 1000, 500});
        precios.put("Vehiculo2", new int[]{500, 3000, 5000});

    }

    public static Precios getInstace() {
        if (precio == null) {
            precio = new Precios();
            return precio;
        } else {
            return precio;
        }
    }
    
    public int[] getPrecio(String construccion){
        return precios.get(construccion);
    }

    
}
