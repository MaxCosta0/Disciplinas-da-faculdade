package com.maxley.enemy;

import com.maxley.attack.Attack;

public class ConcreteEnemy extends Enemy{

    public ConcreteEnemy(Attack attack, Integer lifePoints, Integer positionX, Integer positionY) {
        super(attack, lifePoints, positionX, positionY);
    }
}
