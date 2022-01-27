package com.maxley.personagem;

import com.maxley.ataque.AtaqueForte;
import com.maxley.corrida.CorridaRapido;
import com.maxley.pulo.PuloBaixo;

public class Personagem3 extends Personagem {

    public Personagem3() {
        setPulo(new PuloBaixo());
        setCorrida(new CorridaRapido());
        setAtaque(new AtaqueForte());
    }
}
