package com.maxley.decorator;

import com.maxley.attack.Attack;

public class PoisonDamage extends AttackDecorator{

    public PoisonDamage(Attack attackDecorated) {
        super(attackDecorated);
        System.out.println("Dano de veneno adicionado ao ataque");
        this.buffAttack(4);
    }
}
