package Questao4.validadores;

import java.util.List;

import Questao4.interfaces.IValidador;
import Questao4.modelos.DocumentoFiscal;

public class ValidadorCertificado extends ValidadorBase {

    public ValidadorCertificado() {
        this.setProximo(new ValidadorRegrasFiscais());
    }

    @Override
    public boolean validar(DocumentoFiscal doc, List<IValidador> historico, int falhas) {
        System.out.println("Verificando certificado digital...");

        if (!doc.certificadoValido) {
            falhas++;
            // System.out.println("Certificado inválido.");
            // return false;
        }

        System.out.println(doc.certificadoValido ? "Certificado válido." : "Certificado inválido.");
        historico.add(this);
        return continuar(doc, historico, falhas);
    }
}
