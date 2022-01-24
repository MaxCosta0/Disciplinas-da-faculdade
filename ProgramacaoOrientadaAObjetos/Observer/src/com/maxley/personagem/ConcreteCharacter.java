package com.maxley.personagem;

import com.maxley.estado.EstadoNormal;
import com.maxley.pulo.PuloMedio;

public class ConcreteCharacter extends Personagem{

    public ConcreteCharacter(){
        this.setEnergia(70);
        this.setPulo(new PuloMedio());
        this.setEstado(new EstadoNormal(this));
    }
}
