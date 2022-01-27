package com.maxley.character;

import com.maxley.attack.Attack;
import com.maxley.enemy.Enemy;
import com.maxley.state.State;
import com.maxley.state.StrongState;
import com.maxley.observer.Observable;
import com.maxley.observer.Observer;
import com.maxley.jump.Jump;
import com.maxley.speed.Speed;

import java.util.ArrayList;
import java.util.List;

public abstract class Character implements Observable {
    private Attack attack;
    private Jump jump;
    private Speed speed;
    private Integer lifePoints;
    private State state;
    private List<Observer> observers = new ArrayList<>();
    private Integer positionX;
    private Integer positionY;

    public Character(Attack attack, Jump jump, Speed speed, Integer lifePoints, Integer positionX, Integer positionY) {
        this.attack = attack;
        this.jump = jump;
        this.speed = speed;
        this.state = new StrongState(this);
        this.lifePoints = lifePoints;
        this.positionX = positionX;
        this.positionY = positionY;
    }

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

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }

    public void setSpeed(Speed corrida) {
        this.speed = corrida;
    }

    public void setLifePoints(Integer lifePoints) {
        this.lifePoints = lifePoints;
    }

    public Integer getLifePoints() {
        return lifePoints;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add((observer));
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach((observer) -> observer.update(this));
    }

    public State getState() {
        return state;
    }

    public void toAttack() {        //Triggado quando aperta <<Barra De Espaço>>

        this.observers.forEach(observer -> {

            Enemy enemy = (Enemy) observer;

            if ((enemy.getPositionX() - this.positionX == 0) && (enemy.getPositionY() - this.positionY == 0)) {

                int enemyNewLifePoints = enemy.getLifePoints() - this.attack.toAttack();

                if (enemyNewLifePoints <= 0) {
                    observers.remove(enemy);
                } else {
                    enemy.setLifePoints(enemyNewLifePoints);
                }
            }
        });
    }

    public void toJump() {
        jump.toJump();
    }

    public void run() {
        speed.run();
    }

    public void show(){
        notifyObservers();
    }

}
