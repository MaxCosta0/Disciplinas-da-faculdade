package com.maxley.state;

import com.maxley.attack.WeakAttack;
import com.maxley.character.Character;
import com.maxley.speed.LowSpeed;

public class DangerState extends State {

    public DangerState(Character character) {
        super(character);
    }

    public void setLifePointsLimits() {
        this.setMinLifePoints(0);
        this.setMaxLifePoints(30);
    }

    public void verifyChangeState() {        // Dead -> Danger -> Normal -> Strong
        if (this.getCharacter().getLifePoints() <= this.getMinLifePoints()) {

            this.getCharacter().setState(new DeadState(this.getCharacter()));           // Danger -> Dead

        } else if (this.getCharacter().getLifePoints() >= this.getMaxLifePoints()) {

            this.getCharacter().setState(new NormalState(this.getCharacter()));         //Danger -> Normal
            this.getCharacter().getState().verifyChangeState();                         //Check if we can go Normal -> Strong

        }
    }

    public void setAttack() {
        this.getCharacter().setAttack(new WeakAttack());
    }

    public void setSpeed() {
        this.getCharacter().setSpeed(new LowSpeed());
    }
}
