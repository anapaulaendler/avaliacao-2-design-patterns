package Questao2.interfaces;

import java.util.HashMap;

public interface IProcessadorTransacoes {
    boolean autorizar(String cartao, double valor, String moeda);
    String interpretarResposta(HashMap<String, Object> respostaLegado);
}
