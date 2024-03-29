package com.maxley.enemy;

import com.maxley.character.Character;
import com.maxley.character.ConcreteCharacter;
import com.maxley.character.FuturisticCharacterFactory;
import com.maxley.decorator.FireDamage;
import com.maxley.decorator.IceDamage;
import com.maxley.decorator.PoisonDamage;
import com.maxley.factory.CharacterFactoryMethod;
import com.maxley.state.DangerState;
import com.maxley.state.NormalState;
import com.maxley.state.StrongState;

public class MedievalEnemyFactory extends CharacterFactoryMethod {

    public static final MedievalEnemyFactory instance = new MedievalEnemyFactory();

    //TODO: Modificar para criar inimigos
    public Character createCharacter(double type) {
        Character character = new ConcreteCharacter(0, 0);

        if (type <= 0.2) {
            character.setState(new StrongState(character));
            character.decorateAttack(new FireDamage(character.getAttack()));
        } else if (type > 0.2 && type <= 0.4) {
            character.setState(new NormalState(character));
            character.decorateAttack(new FireDamage(character.getAttack()));
        } else if (type > 0.4 && type <= 0.6) {
            character.setState(new NormalState(character));
            character.decorateAttack(new PoisonDamage(character.getAttack()));
        } else if (type > 0.6 && type <= 0.8) {
            character.setState(new DangerState(character));
            character.decorateAttack(new IceDamage(character.getAttack()));
        } else {
            character.setState(new DangerState(character));
            character.decorateAttack(new PoisonDamage(character.getAttack()));
        }

        return character;
    }

    public MedievalEnemyFactory getInstance() {
        return instance;
    }
}
