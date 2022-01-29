package com.maxley.enemy;

import com.maxley.attack.Attack;
import com.maxley.observer.Observable;
import com.maxley.observer.Observer;
import com.maxley.character.Character;

public abstract class Enemy implements Observer {

    private Attack attack;
    private Integer lifePoints;
    private Integer positionX;
    private Integer positionY;

    public Enemy(Attack attack, Integer lifePoints, Integer positionX, Integer positionY){
        this.attack = attack;
        this.lifePoints = lifePoints;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void update(Observable observable) {
        Character character = (Character) observable;
        Integer characterPositionX = character.getPositionX();
        Integer characterPositionY = character.getPositionY();

        if ((characterPositionX - this.positionX == 0) && (characterPositionY - this.positionY == 0)) {
            character.getDamage(attack.toAttack());

        } else {
            this.positionX += (characterPositionX - this.positionX) > 0 ? (int)(5*Math.random()) : (int)((-5)*Math.random());       // Se a diferença da posição em x do personagem e do inimigo for positiva,
                                                                                                                                    // entao inimigo segue na difeçao positiva, caso contrario inimito segue
                                                                                                                                    // na direção negativa;
            this.positionY += (characterPositionY - this.positionY) > 0 ? (int)(5*Math.random()) : (int)((-5)*Math.random());
        }
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

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public Integer getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(Integer lifePoints) {
        this.lifePoints = lifePoints;
    }
}
