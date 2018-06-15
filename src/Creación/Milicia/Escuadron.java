/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creación.Milicia;

import Creación.Edificio.Edificio;
import java.util.ArrayList;
import victormendoza.s.world.Ini;

/**
 *
 * @author victor
 */
public class Escuadron implements Milicia {

    private int vida;
    private int turnosE;
    private int turnosA;
    private int ataque;
    private String nombre;

    public Escuadron() {
    }

    public Escuadron(int vida, int turnos, int ataque, String nombre, int tiempoA) {
        this.vida = vida;
        this.turnosE = turnos;
        this.ataque = ataque;
        this.turnosA = tiempoA;
        this.nombre = nombre;

    }

    @Override
    public void Atacar(Edificio edificio, byte jugador) {

        Ini ini = Ini.getInstance();
        if (vida != 0) {
            if (edificio.getVida() > 0) {
                edificio.setVida(edificio.getVida() - ataque);
            }
        }else{
            System.out.println("Error: la unidad ya está muerta, no hará daño");
        }

        if (edificio.getVida() == 0) {
            this.turnosA = 0;
        }

    }

    @Override
    public int getAtaque() {
        return ataque;
    }

    public boolean isAlive() {
        if (vida > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean TiempoEntrenar() {
        if (turnosE == 0) {
            turnosE += 1;
            System.out.println("La tropa " + this.nombre + " lista para combatir");
            return true;
        } else {
            turnosE += 1;
            return false;
        }
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean TiempoAtacar() {
        if (turnosA == 0) {
            turnosA += 1;
            return true;
        } else {
            turnosA += 1;
            return false;
        }
    }

    @Override
    public void restarVida(int cantidad) {
        this.vida = this.vida - cantidad;
    }

    @Override
    public int getVida() {
        return vida;
    }

}
