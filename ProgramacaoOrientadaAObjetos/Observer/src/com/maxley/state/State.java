package com.maxley.state;

import com.maxley.character.Character;

public abstract class State {

    private Character character;
    private int maxLifePoints;
    private int minLifePoints;

    public State(Character character) {
        this.character = character;
        setLifePointsLimits();
    }

    protected void setLifePointsLimits(){};
    protected void verifyChangeState(){};

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getMaxLifePoints() {
        return maxLifePoints;
    }

    public void setMaxLifePoints(int maxLifePoints) {
        this.maxLifePoints = maxLifePoints;
    }

    public int getMinLifePoints() {
        return minLifePoints;
    }

    public void setMinLifePoints(int minLifePoints) {
        this.minLifePoints = minLifePoints;
    }
}
