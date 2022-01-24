package com.maxley.personagem;

import com.maxley.ataque.Ataque;
import com.maxley.estado.Estado;
import com.maxley.pulo.Pulo;
import com.maxley.velocidade.Velocidade;

public abstract class Personagem {
    private Ataque ataque;
    private Pulo pulo;
    private Velocidade velocidade;
    private Integer energia;
    private Estado estado;

    public void setAtaque(Ataque ataque){
        this.ataque = ataque;
    }

    public void setPulo(Pulo pulo) {
        this.pulo = pulo;
    }

    public void setVelocidade(Velocidade corrida) {
        this.velocidade = corrida;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void atacar(){
        ataque.atacar();
    }

    public void pular() {
        pulo.pular();
    }

    public void correr() {
        velocidade.correr();
    }

}
