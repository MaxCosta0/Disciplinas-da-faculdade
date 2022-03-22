package com.maxley.game;

import com.maxley.attack.MediumAttack;
import com.maxley.attack.WeakAttack;
import com.maxley.character.Character;
import com.maxley.character.MedievalCharacterFactory;
import com.maxley.decorator.FireDamage;
import com.maxley.decorator.IceDamage;
import com.maxley.decorator.PoisonDamage;
import com.maxley.enemy.ConcreteEnemy;
import com.maxley.factory.GameAbstractFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MedievalGame extends GameAbstractFactory {

    private ConcreteEnemy skeleton;
    private ConcreteEnemy necromorph;
    private ConcreteEnemy vampire;
    private Character player1;

    private static final MedievalGame instance = new MedievalGame();

    public MedievalGame getInstance() {
        return instance;
    }

    public void createCharacter() {
        double randomNumber = Math.random();
        MedievalCharacterFactory medievalCharacterFactory = new MedievalCharacterFactory();
        this.player1 = medievalCharacterFactory.createCharacter(randomNumber);
    }

    //TODO: Implementar medieval enemy factory
    public void createEnemy() {
        skeleton = new ConcreteEnemy(new WeakAttack(), 30, 10, 450);
        necromorph = new ConcreteEnemy(new WeakAttack(), 20, 400, 20);
        vampire = new ConcreteEnemy(new MediumAttack(), 60, 350, 100);
    }

    public MedievalGame() {
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

            if (event.getKeyCode() == KeyEvent.VK_T)                             //Press T to add fire damage to attack
                player1.decorateAttack(new FireDamage(player1.getAttack()));

            if (event.getKeyCode() == KeyEvent.VK_R)                             //Press R to add poison damage to attack
                player1.decorateAttack(new PoisonDamage(player1.getAttack()));

            if (event.getKeyCode() == KeyEvent.VK_Y)                             //Press Y to add ice damage to attack
                player1.decorateAttack(new IceDamage(player1.getAttack()));

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
        g2d.fillRect(skeleton.getPositionX(), skeleton.getPositionY(), 20, 20);

        g2d.setColor(Color.RED);
        g2d.fillRect(necromorph.getPositionX(), necromorph.getPositionY(), 20, 20);

        g2d.setColor(Color.PINK);
        g2d.fillRect(vampire.getPositionX(), vampire.getPositionY(), 20, 20);

    }

    public void play(MedievalGame game) throws InterruptedException {
        JFrame frame = new JFrame("Castlevania");
        frame.add(game);
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createCharacter();
        createEnemy();

        player1.addObserver(skeleton);
        player1.addObserver(necromorph);
        player1.addObserver(vampire);

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
