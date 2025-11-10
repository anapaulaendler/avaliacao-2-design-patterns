package Questao4;

import java.util.ArrayList;

import Questao4.interfaces.IValidador;
import Questao4.modelos.DocumentoFiscal;
import Questao4.validadores.*;

public class Main {
    public static void main(String[] args) {
        IValidador schema = new ValidadorSchema();

        DocumentoFiscal doc1 = new DocumentoFiscal("NF-100", 100.0, true, false, true);

        System.out.println("Validação do Documento 1");
        schema.validar(doc1, new ArrayList<>(), 0);

        DocumentoFiscal doc2 = new DocumentoFiscal("NF-200", 100.0, true, false, false);

        System.out.println("\nValidação do Documento 2");
        schema.validar(doc2, new ArrayList<>(), 0);
    }
}
