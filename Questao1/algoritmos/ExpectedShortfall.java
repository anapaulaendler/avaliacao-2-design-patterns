package Questao1.algoritmos;

public class ExpectedShortfall extends Algoritmo {

    public ExpectedShortfall() {
            super("ES");
        }
    
        @Override
    public double calcularRisco(double valor, double volatidade, double nivelConfianca) {
        return valor * volatidade * (nivelConfianca + 0.33);
    }
    
}
