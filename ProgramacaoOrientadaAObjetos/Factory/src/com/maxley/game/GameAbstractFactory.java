package com.maxley.game;

import javax.swing.*;

public abstract class GameAbstractFactory extends JPanel {

    public abstract void createCharacter();
    public abstract void createEnemy();
}
