package com.maxley.game;

import com.maxley.attack.MediumAttack;
import com.maxley.attack.WeakAttack;
import com.maxley.character.Character;
import com.maxley.decorator.EnergyKatanaDamage;
import com.maxley.decorator.GranadeNoseDamage;
import com.maxley.decorator.LaserDamage;
import com.maxley.enemy.ConcreteEnemy;
import com.maxley.factory.FuturisticCharacterFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class FuturisticGame extends GameAbstractFactory {

    private ConcreteEnemy clown;
    private ConcreteEnemy robot;
    private ConcreteEnemy samurai;

    private Character player1;

    public void createCharacter() {
        double randomNumber = Math.random();
        FuturisticCharacterFactory futuristicCharacterFactory = new FuturisticCharacterFactory();
        this.player1 = futuristicCharacterFactory.createCharacter(randomNumber);
    }

    //TODO: Implementar medieval enemy factory
    public void createEnemy() {
        this.clown = new ConcreteEnemy(new WeakAttack(), 30, 10, 450);
        this.robot = new ConcreteEnemy(new WeakAttack(), 20, 400, 20);
        this.samurai = new ConcreteEnemy(new MediumAttack(), 60, 350, 100);
    }

    public FuturisticGame() {
        KeyListener listener = new GameKeyListener();
        addKeyListener(listener);
        setFocusable(true);
    }

    public class GameKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent event) {
        }

        @Override
        public void keyPressed(KeyEvent event) {

            if (event.getKeyCode() == KeyEvent.VK_LEFT)
                player1.setPositionX(player1.getPositionX() - player1.run());

            if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                player1.setPositionX(player1.getPositionX() + player1.run());

            if (event.getKeyCode() == KeyEvent.VK_UP)
                player1.setPositionY(player1.getPositionY() - player1.run());

            if (event.getKeyCode() == KeyEvent.VK_DOWN)
                player1.setPositionY(player1.getPositionY() + player1.run());

            if (event.getKeyCode() == KeyEvent.VK_SPACE)
                player1.toAttack();

            if (event.getKeyCode() == KeyEvent.VK_T)                             //Press T to add granade nose damage to attack
                player1.decorateAttack(new GranadeNoseDamage(player1.getAttack()));

            if (event.getKeyCode() == KeyEvent.VK_R)                             //Press R to add energy katana damage to attack
                player1.decorateAttack(new EnergyKatanaDamage(player1.getAttack()));

            if (event.getKeyCode() == KeyEvent.VK_Y)                             //Press Y to add laser damage to attack
                player1.decorateAttack(new LaserDamage(player1.getAttack()));

        }

        @Override
        public void keyReleased(KeyEvent event) {
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLUE);
        g2d.fillOval(player1.getPositionX(), player1.getPositionY(), 20, 20);

        g2d.setColor(Color.GREEN);
        g2d.fillRect(clown.getPositionX(), clown.getPositionY(), 20, 20);

        g2d.setColor(Color.RED);
        g2d.fillRect(robot.getPositionX(), robot.getPositionY(), 20, 20);

        g2d.setColor(Color.PINK);
        g2d.fillRect(samurai.getPositionX(), samurai.getPositionY(), 20, 20);

    }

    public void play(FuturisticGame game) throws InterruptedException {
        JFrame frame = new JFrame("Castlevania");
        frame.add(game);
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createCharacter();
        createEnemy();

        player1.addObserver(clown);
        player1.addObserver(robot);
        player1.addObserver(samurai);

        int timeToShield = 0;

        while (true) {
            player1.show();
            game.repaint();
            Thread.sleep(50);

            timeToShield += 50;

            if (timeToShield % 5000 == 0) {
                player1.addShield(10);              //Adiciona 10 de escudo a cada 5 segundos.
                System.out.println("Shield Total: " + player1.getFirstShield().countShieldAbsorb(0));
            }
        }
    }
}
