package com.maxley.character;

import com.maxley.attack.Attack;
import com.maxley.attack.StrongAttack;
import com.maxley.enemy.Enemy;
import com.maxley.jump.HighJump;
import com.maxley.speed.HighSpeed;
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

    public Character(Integer positionX, Integer positionY) {
        this.state = new StrongState(this);
        this.attack = new StrongAttack();
        this.speed = new HighSpeed();
        this.jump = new HighJump();
        this.lifePoints = 100;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    // Observer Pattern methods IN -->

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

    // Observer Pattern methods OUT -->

    //Character actions IN -->

    public void toAttack() {        //trigged when <<Space Bar>> pressed

        for (int i = 0; i < this.observers.size(); i++) {
            Enemy enemy = (Enemy) this.observers.get(i);

            if ((enemy.getPositionX() - this.positionX <= 2) && (enemy.getPositionY() - this.positionY <= 2)) {

                int enemyNewLifePoints = enemy.getLifePoints() - this.attack.toAttack();

                if (enemyNewLifePoints <= 0) {
                    observers.remove(enemy);
                } else {
                    enemy.setLifePoints(enemyNewLifePoints);
                }
            }
        }
    }

    public void toJump() {
        jump.toJump();
    }

    public void run() {
        speed.run();
    }

    //Character actions OUT -->

    public void show() {
        notifyObservers();
    }

    // Getters And Setters IN -->

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.state.setAttack();
    }

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.state.setSpeed();
    }

    public Integer getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(Integer lifePoints) {
        this.lifePoints = lifePoints;
        this.state.verifyChangeState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
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

    // Getters And Setters OUT -->

}
