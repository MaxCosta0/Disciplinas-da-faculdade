package com.maxley.enemy;

import com.maxley.observer.Observable;
import com.maxley.observer.Observer;
import com.maxley.personagem.Personagem;

public abstract class Enemy implements Observer {

    private Integer attackDamage;
    private Integer lifePoints;
    private Integer positionX;
    private Integer positionY;

    public Enemy(Integer attackDamage, Integer lifePoints, Integer positionX, Integer positionY){
        this.attackDamage = attackDamage;
        this.lifePoints = lifePoints;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void update(Observable observable) {
        Personagem character = (Personagem) observable;
        Integer characterPositionX = character.getPositionX();
        Integer characterPositionY = character.getPositionY();

        if ((characterPositionX - this.positionX == 0) && (characterPositionY - this.positionY == 0)) {
            //TODO: Inimigo bate no personagem;
            character.setEnergia(-attackDamage);

        } else {
            //TODO: Inimigo chega mais proximo do personagem;
            this.positionX += (characterPositionX - this.positionX) > 0 ? (int)(5*Math.random()) : (int)((-5)*Math.random());       // Se a diferença da posição em x do personagem e do inimigo for positiva,
                                                                                                                                    // entao inimigo segue na difeçao positiva, caso contrario inimito segue
                                                                                                                                    // na direção negativa;
            this.positionY += (characterPositionY - this.positionY) > 0 ? (int)(5*Math.random()) : (int)((-5)*Math.random());
        }
    }

}
