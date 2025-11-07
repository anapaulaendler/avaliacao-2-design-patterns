package Questao1.algoritmos;

public class ValueAtRisk extends Algoritmo {

    public ValueAtRisk(String nomeAlgoritmo) {
            super("VaT");
        }
    
        @Override
    public double calcularRisco(double valor, double volatidade, double nivelConfianca) {
        return valor * (volatidade + nivelConfianca + 0.99);
    }
    
}
