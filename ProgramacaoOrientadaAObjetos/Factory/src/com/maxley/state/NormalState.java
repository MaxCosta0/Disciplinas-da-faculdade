package com.maxley.state;

import com.maxley.attack.MediumAttack;
import com.maxley.character.Character;
import com.maxley.speed.MediumSpeed;

public class NormalState extends State {

    public NormalState(Character character) {
        super(character);
    }

    public void setLifePointsLimits() {
        this.setMinLifePoints(30);
        this.setMaxLifePoints(70);
    }

    public void verifyChangeState() {        // Dead -> Danger -> Normal -> Strong
        if (this.getCharacter().getLifePoints() < this.getMinLifePoints()) {

            this.getCharacter().setState(new DangerState(this.getCharacter()));         //Normal -> Danger
            this.getCharacter().getState().verifyChangeState();                         //Check if we can go Danger -> Dead

        } else if (this.getCharacter().getLifePoints() > this.getMaxLifePoints()) {

            this.getCharacter().setState(new StrongState(this.getCharacter()));         //Normal -> Danger

        }
    }

    public void setAttack() {
        this.getCharacter().setAttack(new MediumAttack());
    }

    public void setSpeed() {
        this.getCharacter().setSpeed(new MediumSpeed());
    }
}
