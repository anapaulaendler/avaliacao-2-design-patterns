package Questao4.modelos;

public class DocumentoFiscal {
    public String id;
    public double impostos;
    public boolean certificadoValido;
    public boolean duplicado;
    public boolean sefazOk;
    public boolean salvoNoBanco = false;

    public DocumentoFiscal(String id, double impostos, boolean certificadoValido, boolean duplicado, boolean sefazOk) {
        this.id = id;
        this.impostos = impostos;
        this.certificadoValido = certificadoValido;
        this.duplicado = duplicado;
        this.sefazOk = sefazOk;
    }
}
