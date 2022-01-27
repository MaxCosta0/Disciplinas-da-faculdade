package com.maxley.attack;

public class WeakAttack implements Attack{
    private int damage = 10;

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
