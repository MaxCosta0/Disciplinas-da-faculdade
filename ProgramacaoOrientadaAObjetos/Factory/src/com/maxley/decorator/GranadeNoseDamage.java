package com.maxley.decorator;

import com.maxley.attack.Attack;

public class GranadeNoseDamage extends AttackDecorator {

    public GranadeNoseDamage(Attack attackDecorated) {
        super(attackDecorated);
        System.out.println("Dano de nariz granada adicionado ao ataque");
        this.buffAttack(9);
    }
}
