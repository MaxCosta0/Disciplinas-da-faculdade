package com.maxley;

import com.maxley.game.Game;

public class Main {

    public static void main(String[] args) throws InterruptedException {

       Game game = new Game();

       game.jogar(game);
    }
}
