package com.maxley.enemy;

import com.maxley.character.Character;
import com.maxley.character.ConcreteCharacter;
import com.maxley.character.FuturisticCharacterFactory;
import com.maxley.decorator.EnergyKatanaDamage;
import com.maxley.decorator.GranadeNoseDamage;
import com.maxley.decorator.LaserDamage;
import com.maxley.factory.CharacterFactoryMethod;
import com.maxley.state.DangerState;
import com.maxley.state.NormalState;
import com.maxley.state.StrongState;

public class FuturisticEnemyFactory extends CharacterFactoryMethod {

    public static final FuturisticCharacterFactory instance = new FuturisticCharacterFactory();

    //TODO: Modificar para criar inimigos
    public Character createCharacter(double type) {
        Character character = new ConcreteCharacter(0, 0);

        if (type <= 0.2) {
            character.setState(new StrongState(character));
            character.decorateAttack(new GranadeNoseDamage(character.getAttack()));
        } else if (type > 0.2 && type <= 0.4) {
            character.setState(new NormalState(character));
            character.decorateAttack(new LaserDamage(character.getAttack()));
        } else if (type > 0.4 && type <= 0.6) {
            character.setState(new NormalState(character));
            character.decorateAttack(new EnergyKatanaDamage(character.getAttack()));
        } else if (type > 0.6 && type <= 0.8) {
            character.setState(new DangerState(character));
            character.decorateAttack(new GranadeNoseDamage(character.getAttack()));
        } else {
            character.setState(new DangerState(character));
            character.decorateAttack(new EnergyKatanaDamage(character.getAttack()));
        }

        return character;
    }

    public FuturisticCharacterFactory getInstance() {
        return instance;
    }
}
