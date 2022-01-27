package com.maxley.state;

import com.maxley.character.Character;

public class DeadState extends State {

    public DeadState(Character character) {
        super(character);
        System.out.println("Game Over!!!");
    }
}
