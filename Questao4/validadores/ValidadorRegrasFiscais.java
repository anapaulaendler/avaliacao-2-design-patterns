package Questao4.validadores;

import java.util.List;

import Questao4.interfaces.IValidador;
import Questao4.modelos.DocumentoFiscal;

public class ValidadorRegrasFiscais extends ValidadorBase {
    public ValidadorRegrasFiscais() {
        this.setProximo(new ValidadorBancoDeDados());
    }
    
    @Override
    public boolean validar(DocumentoFiscal doc, List<IValidador> historico, int falhas) {
        System.out.println("Verificando regras fiscais...");

        if (falhas > 0) {
            System.out.println("Falhas anteriores impedem que o Validador de Regras Fiscais prossiga. Dando rollback...");
            rollbackTudo(historico, doc);
            return false;
        }

        if (doc.impostos < 0) {
            falhas++;
        }

        System.out.println(doc.impostos < 0 ? "Regras fiscais OK." : "Erro nos impostos.");
        historico.add(this);
        return continuar(doc, historico, falhas);
    }
}