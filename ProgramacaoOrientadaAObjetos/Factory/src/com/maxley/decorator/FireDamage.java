package com.maxley.decorator;

import com.maxley.attack.Attack;

public class FireDamage extends AttackDecorator{

    public FireDamage(Attack attackDecorated) {
        super(attackDecorated);
        System.out.println("Dano de fogo adicionado ao ataque");
        this.buffAttack(5);
    }
}
