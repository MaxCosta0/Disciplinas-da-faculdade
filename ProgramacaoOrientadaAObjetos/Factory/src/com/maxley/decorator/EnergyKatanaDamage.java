package com.maxley.decorator;

import com.maxley.attack.Attack;

public class EnergyKatanaDamage extends AttackDecorator{

    public EnergyKatanaDamage(Attack attackDecorated) {
        super(attackDecorated);
        System.out.println("Dano de katana energetica adicionado ao ataque");
        this.buffAttack(7);
    }
}
