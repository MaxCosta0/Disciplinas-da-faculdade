package com.maxley.decorator;

import com.maxley.attack.Attack;

public class IceDamage extends AttackDecorator{

    public IceDamage(Attack attackDecorated) {
        super(attackDecorated);
        System.out.println("Dano de gelo adicionado ao ataque");
        this.buffAttack(2);
    }
}
