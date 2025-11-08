package Questao2.legado;

import java.util.HashMap;

public class SistemaBancarioLegado {
    public HashMap<String, Object> processarTransacao(HashMap<String, Object> parametros) {
        HashMap<String, Object> resposta = new HashMap<>();
        
        String numeroCartao = (String) parametros.get("numeroCartao");
        Double valor = (Double) parametros.get("valorTransacao");
        Integer codigoMoeda = (Integer) parametros.get("codigoMoeda");
        String merchantCode = (String) parametros.get("codigoMerchant");
        
        if (merchantCode == null || merchantCode.trim().isEmpty()) {
            throw new RuntimeException("Código merchant obrigatório não informado");
        }

        if (codigoMoeda == null) {
            throw new RuntimeException("Código moeda é obrigatório no sistema legado");
        }
        
        boolean aprovado = numeroCartao != null && valor != null && valor > 0 && Math.random() > 0.3;
        resposta.put("transacaoAprovada", aprovado);
        resposta.put("codigoResposta", aprovado ? "000" : "101");
        resposta.put("mensagemLegada", aprovado ? "APROVADA" : "RECUSADA");
        
        return resposta;
    }
}