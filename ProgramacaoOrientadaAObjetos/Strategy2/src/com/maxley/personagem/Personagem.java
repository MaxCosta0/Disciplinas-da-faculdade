package com.maxley.personagem;

import com.maxley.ataque.Ataque;
import com.maxley.corrida.Corrida;
import com.maxley.pulo.Pulo;

public abstract class Personagem {
    private Ataque ataque;
    private Pulo pulo;
    private Corrida corrida;

    public void setAtaque(Ataque ataque){
        this.ataque = ataque;
    }

    public void setPulo(Pulo pulo) {
        this.pulo = pulo;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }

    public void atacar(){
        ataque.atacar();
    }

    public void pular() {
        pulo.pular();
    }

    public void correr() {
        corrida.correr();
    }

}
