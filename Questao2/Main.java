package Questao2;

import java.util.HashMap;

import Questao2.adapter.ProcessadorTransacoes;

public class Main {
    public static void main(String[] args) {
        final String CARTAO = "111.111";
        final double VALOR = 111.11;
        final String MOEDA = "BRL";


        ProcessadorTransacoes adapter = new ProcessadorTransacoes();
        adapter.autorizar(CARTAO, VALOR, MOEDA);

        HashMap<String, Object> respostaLegado = adapter.converterParaLegado(CARTAO, VALOR, MOEDA);
        adapter.interpretarResposta(respostaLegado);
    }
}
