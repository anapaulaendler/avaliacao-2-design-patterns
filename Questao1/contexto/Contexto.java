package Questao1.contexto;

import Questao1.algoritmos.Algoritmo;
import Questao1.modelos.ModeloRisco;

public class Contexto {
    private Algoritmo _algoritmo;

    public Contexto(Algoritmo algoritmo) {
        this.setAlgoritmo(algoritmo);
    }

    public void setAlgoritmo(Algoritmo algoritmo) {
        this._algoritmo = algoritmo;
    }

    public void analisar(ModeloRisco modeloRisco) {
        _algoritmo.analisar(modeloRisco);
    }
}
