package com.maxley.personagem;

import com.maxley.ataque.AtaqueMedio;
import com.maxley.corrida.CorridaRapido;
import com.maxley.pulo.PuloAlto;

public class Personagem2 extends Personagem {

    public Personagem2(){
        setPulo(new PuloAlto());
        setCorrida(new CorridaRapido());
        setAtaque(new AtaqueMedio());
    }
}
