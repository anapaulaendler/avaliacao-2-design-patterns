package Questao4.validadores;

import java.util.List;

import Questao4.interfaces.IValidador;
import Questao4.modelos.DocumentoFiscal;

public abstract class ValidadorBase implements IValidador {
    protected IValidador proximo;

    @Override
    public void setProximo(IValidador proximo) {
        this.proximo = proximo;
    }

    protected boolean continuar(DocumentoFiscal doc, List<IValidador> historico, int falhas) {
        if (falhas >= 3) {
            System.out.println("Circuit breaker ativado: parando validações.");
            rollbackTudo(historico, doc);
            return false;
        }
        if (proximo != null) {
            return proximo.validar(doc, historico, falhas);
        }
        System.out.println("Todas as validações passaram");
        return true;
    }

    protected void rollbackTudo(List<IValidador> historico, DocumentoFiscal doc) {
        System.out.println("Iniciando rollback...");
        for (int i = historico.size() - 1; i >= 0; i--) {
            historico.get(i).rollback(doc);
        }
    }
}