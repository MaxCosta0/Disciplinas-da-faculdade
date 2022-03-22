package com.maxley.factory;

import com.maxley.character.Character;

public abstract class CharacterFactoryMethod {
    public abstract Character createCharacter(double type);

    public void play() {
        double randomNumber = Math.random();

        Character player1 = createCharacter(randomNumber);
        Character player2 = createCharacter(randomNumber);
    }
}
