package interfaces;

public interface IEstado {
    void setOperacaoNormal();
    void setAlertaAmarelo();
    void setAlertaVermelho();
    void setEmergencia();
    void iniciarManutencao();
    void finalizarManutencao();
    void setDesligada();
    void verificarTransicao(double temperatura, boolean falhaResfriamento);
}
