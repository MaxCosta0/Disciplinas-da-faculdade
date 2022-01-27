package com.maxley.attack;

public class MediumAttack implements Attack {
    private int damage = 30;

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public int toAttack() {
        return this.damage;
    }
}
