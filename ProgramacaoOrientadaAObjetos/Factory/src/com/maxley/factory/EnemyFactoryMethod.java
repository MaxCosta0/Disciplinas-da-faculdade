package com.maxley.factory;

import com.maxley.character.Character;
import com.maxley.enemy.Enemy;

public abstract class EnemyFactoryMethod {
    public abstract Enemy createEnemy (double type);

    public void play() {
        double randomNumber = Math.random();

        Enemy enemy1 = createEnemy(randomNumber);
        Enemy enemy2 = createEnemy(randomNumber);
    }
}
