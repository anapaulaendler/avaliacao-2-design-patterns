package Questao4.interfaces;

import java.util.List;

import Questao4.modelos.DocumentoFiscal;

public interface IValidador {
    void setProximo(IValidador proximo);
    boolean validar(DocumentoFiscal doc, List<IValidador> historico, int falhas);

    /* apesar de ser uma interface, ela toma essa implementação default! foi introduzido no
     * java 8 pelo o que eu pesquisei, bem legal!
    */
    default void rollback(DocumentoFiscal doc) {}
}