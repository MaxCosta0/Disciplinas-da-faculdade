package com.maxley.decorator;

import com.maxley.attack.Attack;

public abstract class AttackDecorator extends Attack {

    private Attack attackDecorated;

    public AttackDecorator(Attack attackDecorated) {
        this.attackDecorated = attackDecorated;
    }

    public Attack getAttackDecorated() {
        return attackDecorated;
    }

    public void setAttackDecorated(Attack attackDecorated) {
        this.attackDecorated = attackDecorated;
    }

    public void buffAttack(int additionalDamage){
        this.setAttackDamage(this.getAttackDecorated().getAttackDamage() + additionalDamage);
        this.setAttackDecorated(this);
    }
}
