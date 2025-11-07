package Questao2.interfaces;

public interface IProcessarTransacoes {
    boolean autorizar(String cartao, double valor, String moeda);
}
