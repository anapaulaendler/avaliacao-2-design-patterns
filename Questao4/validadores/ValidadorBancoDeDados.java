package Questao4.validadores;

import java.util.List;

import Questao4.interfaces.IValidador;
import Questao4.modelos.DocumentoFiscal;

public class ValidadorBancoDeDados extends ValidadorBase {
    public ValidadorBancoDeDados() {
        this.setProximo(new ValidadorSefaz());
    }
    
    @Override
    public boolean validar(DocumentoFiscal doc, List<IValidador> historico, int falhas) {
        System.out.println("Verificando duplicidade no banco...");

        if (doc.duplicado) {
            falhas++;
            System.out.println("Documento duplicado!");
            rollbackTudo(historico, doc);
            return false;
        }
        
        System.out.println("Documento inserido no banco.");
        doc.salvoNoBanco = true;
        historico.add(this);
        return continuar(doc, historico, falhas);
    }

    @Override
    public void rollback(DocumentoFiscal doc) {
        if (doc.salvoNoBanco) {
            System.out.println("Removendo documento do banco (rollback).");
            doc.salvoNoBanco = false;
        }
    }
}
