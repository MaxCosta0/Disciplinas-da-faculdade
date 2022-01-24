package com.maxley.personagem;

import com.maxley.estado.EstadoNormal;
import com.maxley.pulo.PuloMedio;

public class Personagem1 extends Personagem{

    public Personagem1(){
        this.setEnergia(70);
        this.setPulo(new PuloMedio());
        this.setEstado(new EstadoNormal(this));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
