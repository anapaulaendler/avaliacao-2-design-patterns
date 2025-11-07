package Questao1.algoritmos;

import Questao1.interfaces.IAlgoritmo;
import Questao1.modelos.ModeloRisco;

public abstract class Algoritmo implements IAlgoritmo {
    protected String nomeAlgoritmo;

    public Algoritmo(String nomeAlgoritmo) {
        this.nomeAlgoritmo = nomeAlgoritmo;
    }

    public void analisar(ModeloRisco modeloRisco) {
        double risco = calcularRisco(modeloRisco.valor, modeloRisco.volatidade, modeloRisco.nivelConfianca);

        System.out.printf("Usando:\n- Valor: R$ %.2f\n- Volatidade: %.2f\n- Confiança: %.2f\n", modeloRisco.valor, modeloRisco.volatidade, modeloRisco.nivelConfianca);
        System.out.printf("Resultado %s: %.2f", nomeAlgoritmo, risco);
    }
}
