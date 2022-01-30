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

    // State specific methods IN -->

    protected void setLifePointsLimits(){};
    public void verifyChangeState(){};
    public void setAttack(){};
    public void setSpeed(){};

    // State specific methods OUT -->

    // Getters And Setters IN -->

    public Character getCharacter() {
        return character;
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

    // Getters And Setters OUT -->
}
