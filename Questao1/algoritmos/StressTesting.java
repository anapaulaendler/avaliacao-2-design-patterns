package Questao1.algoritmos;

public class StressTesting extends Algoritmo {

    public StressTesting() {
            super("ST");
        }
    
        @Override
    public double calcularRisco(double valor, double volatidade, double nivelConfianca) {
        return valor * (volatidade + 0.66) * nivelConfianca;
    }
    
}
