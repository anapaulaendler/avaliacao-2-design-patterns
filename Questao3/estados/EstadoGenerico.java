package estados;

import client.UsinaNuclear;
import interfaces.IEstado;

/* Por padrão, todos os métodos de transição são proibidos / inválidos
 * já que é preferencial que cada estado específico implemente sua própria lógica
 * e, em caso de "esquecimento" ou falha humana dentro do código, é preferível
 * que uma transição inválida seja reportada do que permitir uma transição incorreta.
 */
public abstract class EstadoGenerico implements IEstado {
    protected UsinaNuclear usina;

    protected EstadoGenerico(UsinaNuclear usina) {
        this.usina = usina;
    }

    @Override
    public void setOperacaoNormal() {
        naoPermitido("ligar");
    }

    @Override
    public void setAlertaAmarelo() {
        naoPermitido("setAlertaAmarelo");
    }

    @Override
    public void setAlertaVermelho() {
        naoPermitido("setAlertaVermelho");
    }

    @Override
    public void setEmergencia() {
        naoPermitido("setEmergencia");
    }

    @Override
    public void iniciarManutencao() {
        naoPermitido("iniciarManutencao");
    }

    @Override
    public void finalizarManutencao() {
        naoPermitido("finalizarManutencao");
    }

    @Override
    public void setDesligada() {
        naoPermitido("desligar");
    }

    private void naoPermitido(String acao) {
        System.out.println("[TRANSIÇÃO INVÁLIDA] Não é possível " + acao + " no estado atual (" + this.getClass().getSimpleName() + ")");
    }
}