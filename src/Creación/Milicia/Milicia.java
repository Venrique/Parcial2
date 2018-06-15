/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Milicia;

import Creación.Edificio.Edificio;

/**
 *
 * @author victor
 */
public interface Milicia {
    public void Atacar(Edificio edificio,byte jugador);
    public int getAtaque();
    public boolean TiempoEntrenar();
    public boolean TiempoAtacar();
    public String getNombre();
    public void restarVida(int cantidad);
    public int getVida();
}
