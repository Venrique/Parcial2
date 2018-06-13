/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victormendoza.s.world;

/**
 *
 * @author victor
 */
public class Validaciones {

    private static Validaciones validar;

    private Validaciones() {

    }

    public static Validaciones getInstance() {
        if (validar == null) {
            validar = new Validaciones();
            return validar;
        } else {
            return validar;
        }
    }

    public boolean ValidarRecursos(byte jugador, String construccion) {
        Precios precio = Precios.getInstace();
        Ini ini = Ini.getInstance();
        
        //SE VERIFICA QUE LOS RECURSOS DEL JUGADOR EN SU CENTRO DE MANDO SEAN MAYORES AL COSTO DE CREACIÓN
        if (jugador == 0) {
            if (ini.p1.getEdificiosC().get(0).getRecursos().get(0).getCantidad() >= precio.getPrecioI(construccion)[0]) {
                if (ini.p1.getEdificiosC().get(0).getRecursos().get(1).getCantidad() >= precio.getPrecioI(construccion)[1]) {
                    if (ini.p1.getEdificiosC().get(0).getRecursos().get(2).getCantidad() >= precio.getPrecioI(construccion)[2]) {
                        ini.p1.getEdificiosC().get(0).getRecursos().get(0).restar(precio.getPrecioI(construccion)[0]);
                        ini.p1.getEdificiosC().get(0).getRecursos().get(1).restar(precio.getPrecioI(construccion)[1]);
                        ini.p1.getEdificiosC().get(0).getRecursos().get(2).restar(precio.getPrecioI(construccion)[2]);
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (ini.p2.getEdificiosC().get(0).getRecursos().get(0).getCantidad() >= precio.getPrecioI(construccion)[0]) {
                if (ini.p2.getEdificiosC().get(0).getRecursos().get(1).getCantidad() >= precio.getPrecioI(construccion)[1]) {
                    if (ini.p2.getEdificiosC().get(0).getRecursos().get(2).getCantidad() >= precio.getPrecioI(construccion)[2]) {
                        ini.p2.getEdificiosC().get(0).getRecursos().get(0).restar(precio.getPrecioI(construccion)[0]);
                        ini.p2.getEdificiosC().get(0).getRecursos().get(1).restar(precio.getPrecioI(construccion)[1]);
                        ini.p2.getEdificiosC().get(0).getRecursos().get(2).restar(precio.getPrecioI(construccion)[2]);
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
