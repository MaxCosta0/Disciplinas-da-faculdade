package com.maxley.estado;

import com.maxley.ataque.AtaqueFraco;
import com.maxley.personagem.Personagem;
import com.maxley.velocidade.VelocidadeLento;

public class EstadoPerigo extends Estado {

    public EstadoPerigo(Personagem personagem){
        super(personagem);
        setLimitesEnergia();
        verificaAlteracaoEstado();
        setAtributos();
    }

    public void setLimitesEnergia() {
        this.setEnergiaMinima(1);
        this.setEnergiaMaxima(29);
    }

    public void verificaAlteracaoEstado() {
        Personagem personagem = this.getPersonagem();
        Integer energiaPersonagem = personagem.getEnergia();

        if (energiaPersonagem < this.getEnergiaMinima()) {
            personagem.setEstado(new EstadoMorto(personagem));
        } else if (energiaPersonagem > this.getEnergiaMaxima()) {
            personagem.setEstado(new EstadoNormal(personagem));
        }
    }

    protected void setAtributos() {
        this.getPersonagem().setAtaque(new AtaqueFraco());
        this.getPersonagem().setVelocidade(new VelocidadeLento());
    }
}
