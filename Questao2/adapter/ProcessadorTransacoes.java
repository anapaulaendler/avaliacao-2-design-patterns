package Questao2.adapter;

import java.util.HashMap;

import Questao2.interfaces.IProcessadorTransacoes;
import Questao2.legado.SistemaBancarioLegado;

public class ProcessadorTransacoes implements IProcessadorTransacoes {
    private SistemaBancarioLegado _legado;
    private String _codigoMerchant;

    public ProcessadorTransacoes() {
        this._legado = new SistemaBancarioLegado();
        this._codigoMerchant = "CODIGO_DEFAULT";
    }

    // CONVERSÃO IDA: Interface moderna -> Legado
    @Override
    public boolean autorizar(String cartao, double valor, String moeda) {
        HashMap<String, Object> parametrosLegado = converterParaLegado(cartao, valor, moeda);
        HashMap<String, Object> respostaLegado = _legado.processarTransacao(parametrosLegado);
        return converterResposta(respostaLegado);
    }

    // CONVERSÃO VOLTA: Legado -> Interface moderna 
    @Override
    public String interpretarResposta(HashMap<String, Object> respostaLegado) {
        return formatarRespostaModerno(respostaLegado);
    }

    // MÉTODO SETADO PARA PÚBLICO PARA FACILITAR TESTES. Em um caso real, ele provavelmente seria privado.
    public HashMap<String, Object> converterParaLegado(String cartao, double valor, String moeda) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("numeroCartao", cartao);
        parametros.put("valorTransacao", valor);
        parametros.put("codigoMoeda", converterMoeda(moeda));
        parametros.put("codigoMerchant", _codigoMerchant);
        return parametros;
    }

    private int converterMoeda(String moeda) {
        switch (moeda.toUpperCase()) {
            case "USD": return 1;
            case "EUR": return 2;
            case "BRL": return 3;
            default: throw new IllegalArgumentException("Moeda não suportada: " + moeda);
        }
    }

    private boolean converterResposta(HashMap<String, Object> respostaLegado) {
        Boolean sucesso = (Boolean) respostaLegado.get("transacaoAprovada");
        return sucesso != null && sucesso;
    }
    
    private String formatarRespostaModerno(HashMap<String, Object> respostaLegado) {
        Boolean sucesso = (Boolean) respostaLegado.get("transacaoAprovada");
        String codigoResposta = (String) respostaLegado.get("codigoResposta");
        String mensagem = (String) respostaLegado.get("mensagemLegada");
        
        return String.format("Status: %s | Código: %s | Mensagem: %s",
                Boolean.TRUE.equals(sucesso) ? "APROVADO" : "RECUSADO", codigoResposta, mensagem);
    }
}
