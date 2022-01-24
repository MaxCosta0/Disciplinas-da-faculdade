package com.maxley.personagem;

import com.maxley.ataque.Ataque;
import com.maxley.estado.Estado;
import com.maxley.observer.Observable;
import com.maxley.observer.Observer;
import com.maxley.pulo.Pulo;
import com.maxley.velocidade.Velocidade;

import java.util.List;

public abstract class Personagem implements Observable {
    private Ataque ataque;
    private Pulo pulo;
    private Velocidade velocidade;
    private Integer energia;
    private Estado estado;

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    private Integer positionX;
    private Integer positionY;
    private List<Observer> observers;

    public void setAtaque(Ataque ataque) {
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


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void subscribe(Observer observer) {
        this.observers.add((observer));
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void publish() {
        //TODO: entender como implementar essa bosta
    }

    public Estado getEstado() {
        return estado;
    }

    public void atacar() {
        ataque.atacar();
    }

    public void pular() {
        pulo.pular();
    }

    public void correr() {
        velocidade.correr();
    }

}
