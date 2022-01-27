package com.maxley.game;

import com.maxley.character.Character;
import com.maxley.character.ConcreteCharacter;
import com.maxley.enemy.ConcreteEnemy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Game extends JPanel {

    private ConcreteEnemy skeleton;
    private ConcreteEnemy necromorph;
    private ConcreteEnemy vampire;
    private Character player1;

    public Game() {
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
                player1.setPositionX(player1.getPositionX() - player1.getSpeed().run());

            if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                player1.setPositionX(player1.getPositionX() + player1.getSpeed().run());

            if (event.getKeyCode() == KeyEvent.VK_UP)
                player1.setPositionY(player1.getPositionY() - player1.getSpeed().run());

            if (event.getKeyCode() == KeyEvent.VK_DOWN)
                player1.setPositionY(player1.getPositionY() + player1.getSpeed().run());

            if (event.getKeyCode() == KeyEvent.VK_SPACE)
                player1.toAttack();
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

    public void jogar(Game game) throws InterruptedException {
        JFrame frame = new JFrame("Castlevania");
        frame.add(game);
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        player1 = new ConcreteCharacter(50, 50);
        skeleton = new ConcreteEnemy(5, 30, 10, 450);
        necromorph = new ConcreteEnemy(7, 20, 400, 20);
        vampire = new ConcreteEnemy(8, 60, 350, 100);

        player1.addObserver(skeleton);
        player1.addObserver(necromorph);
        player1.addObserver(vampire);

        while (true) {
            player1.show();
            game.repaint();
            Thread.sleep(50);
        }

    }
}
