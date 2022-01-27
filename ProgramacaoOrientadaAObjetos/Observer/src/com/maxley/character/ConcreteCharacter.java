package com.maxley.character;

import com.maxley.attack.Attack;
import com.maxley.jump.Jump;
import com.maxley.speed.Speed;

public class ConcreteCharacter extends Character {

    public ConcreteCharacter(Attack ataque, Jump pulo, Speed velocidade, Integer energia, Integer positionX, Integer positionY) {
        super(ataque, pulo, velocidade, energia, positionX, positionY);
    }
}
