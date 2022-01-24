package com.maxley.estado;

import com.maxley.ataque.AtaqueForte;
import com.maxley.personagem.Personagem;
import com.maxley.velocidade.VelocidadeRapido;

public class EstadoForte extends Estado {

    public EstadoForte(Personagem personagem) {
        super(personagem);
        setLimitesEnergia();
        verificaAlteracaoEstado();
        setAtributos();
    }

    protected void setLimitesEnergia() {
        this.setEnergiaMinima(71);
        this.setEnergiaMaxima(100);
    }

    public void verificaAlteracaoEstado() {
        Personagem personagem = this.getPersonagem();
        Integer energiaPersonagem = personagem.getEnergia();

        if (energiaPersonagem < this.getEnergiaMinima()) {
            personagem.setEstado(new EstadoNormal(personagem));
        }
    }

    protected void setAtributos() {
        this.getPersonagem().setAtaque(new AtaqueForte());
        this.getPersonagem().setVelocidade(new VelocidadeRapido());
    }
}
