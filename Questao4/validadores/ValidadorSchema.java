package Questao4.validadores;

import java.util.List;

import Questao4.interfaces.IValidador;
import Questao4.modelos.DocumentoFiscal;

public class ValidadorSchema extends ValidadorBase {

    public ValidadorSchema() {
        this.setProximo(new ValidadorCertificado());
    }

    @Override
    public boolean validar(DocumentoFiscal doc, List<IValidador> historico, int falhas) {
        System.out.println("Verificando schema XML...");
        boolean ok = (int)(Math.random() * 101) % 2 == 0;

        if (!ok) {
            falhas++;
            // Seguindo o requisito: "A cadeia deve suportar validações condicionais (se validador X falhar, pule Y)"
            this.setProximo(new ValidadorRegrasFiscais());
            // Inicialmente, a ideia era fazer rollback em todos, mas considerando a questão,
            // esse rollback deve acontecer em 3 momentos: nos validadores 3 e 5 se tiver qualquer
            // tipo de falha + no banco de dados!
            // rollbackTudo(historico, doc);
            // return false;
        }

        System.out.println(ok ? "XML válido." : "Schema inválido.");
        
        historico.add(this);
        return continuar(doc, historico, falhas);
    }
}
