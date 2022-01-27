package com.maxley.attack;

public class StrongAttack implements Attack {
    private Integer damage = 50;

    public int toAttack() {
        return this.damage;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }
}
