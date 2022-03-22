package com.maxley.decorator;

import com.maxley.attack.Attack;

public class LaserDamage extends AttackDecorator{

    public LaserDamage(Attack attackDecorated) {
        super(attackDecorated);
        System.out.println("Dano de laser adicionado ao ataque");
        this.buffAttack(5);
    }
}