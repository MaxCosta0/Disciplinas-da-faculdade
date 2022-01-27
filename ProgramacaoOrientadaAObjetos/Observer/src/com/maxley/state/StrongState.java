package com.maxley.state;

import com.maxley.attack.StrongAttack;
import com.maxley.character.Character;
import com.maxley.speed.HighSpeed;

public class StrongState extends State {

    public StrongState(Character character) {
        super(character);
    }

    public void setLifePointsLimits() {
        this.setMinLifePoints(70);
        this.setMaxLifePoints(100);
    }

    public void verifyChangeState() {        // Dead -> Danger -> Normal -> Strong
        if (this.getCharacter().getLifePoints() <= this.getMinLifePoints()) {

            this.getCharacter().setState(new NormalState(this.getCharacter()));         // Strong -> Normal
            this.getCharacter().getState().verifyChangeState();                         //Check if we can go Normal -> Danger or Danger -> Dead

        } else if (this.getCharacter().getLifePoints() > this.getMaxLifePoints()) {

            this.getCharacter().setLifePoints(100);                                     //Maximum possible life points must to be 100

        }
    }

    public void setAttack() {
        this.getCharacter().setAttack(new StrongAttack());
    }

    public void setSpeed() {
        this.getCharacter().setSpeed(new HighSpeed());
    }
}
