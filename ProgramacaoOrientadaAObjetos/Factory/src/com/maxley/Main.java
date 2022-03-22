package com.maxley;

import com.maxley.game.MedievalGame;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MedievalGame medievalGame = new MedievalGame();
        medievalGame.play(medievalGame);


//        FuturisticGame futuristicGame = new FuturisticGame();
//        futuristicGame.play(futuristicGame);

//        ==================== TEST OF SIMPLE FACTORY ====================
//        FuturisticCharacterFactory simpleCharacterFactory = new FuturisticCharacterFactory();
//        MedievalCharacterFactory advancedCharacterFactory = new MedievalCharacterFactory();
//
//        simpleCharacterFactory.play();
//        advancedCharacterFactory.play();
//
//
//        Character randomSimpleCharacter = simpleCharacterFactory.createCharacter(randomNumber);
//        Character randomAdvancedCharacter = advancedCharacterFactory.createCharacter(randomNumber);

    }
}
