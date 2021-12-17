package com.maxley;

import com.maxley.personagem.Personagem1;
import com.maxley.personagem.Personagem2;
import com.maxley.personagem.Personagem3;

public class Main {

    public static void main(String[] args) {

        Personagem1 personagem1 = new Personagem1();
        Personagem2 personagem2 = new Personagem2();
        Personagem3 personagem3 = new Personagem3();

        System.out.println("Personagem1: ");
        personagem1.pular();
        personagem1.correr();
        personagem1.atacar();
        System.out.println();

        System.out.println("Personagem2: ");
        personagem2.pular();
        personagem2.correr();
        personagem2.atacar();
        System.out.println();

        System.out.println("Personagem3: ");
        personagem3.pular();
        personagem3.correr();
        personagem3.atacar();
    }
}
