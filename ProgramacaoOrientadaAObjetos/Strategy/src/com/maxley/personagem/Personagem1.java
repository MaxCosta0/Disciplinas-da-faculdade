package com.maxley.personagem;

import com.maxley.ataque.AtaqueForte;
import com.maxley.corrida.CorridaMedio;
import com.maxley.pulo.PuloMedio;

public class Personagem1 extends Personagem{
    public Personagem1(){
        setPulo(new PuloMedio());
        setCorrida(new CorridaMedio());
        setAtaque(new AtaqueForte());
    }
}
