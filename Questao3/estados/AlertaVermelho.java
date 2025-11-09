package estados;

import client.UsinaNuclear;

/* Você NÃO pode passar o estado Emergência de forma forçada, ele precisa da validação
 * dos parâmetros na verificação de transição.
 */
public class AlertaVermelho extends EstadoGenerico {

    public AlertaVermelho(UsinaNuclear usina) {
        super(usina);
    }

    @Override
    public void setAlertaVermelho() {
        System.out.println("Usina já em Estado Vermelho.");
    }

    @Override
    public void setDesligada() {
        System.out.println("Alerta vermelho -> Desligada (desligando usina)");
        usina.setEstado(new Desligada(usina));
    } 

    @Override
    public void setAlertaAmarelo() {
        System.out.println("Alerta vermelho -> Alerta amarelo (forçado)");
        usina.setEstado(new AlertaAmarelo(usina));
    }

    @Override
    public void iniciarManutencao() {
        System.out.println("Alerta vermelho -> Manutenção");
        usina.setEstado(new Manutencao(usina));
    }

    @Override
    public void verificarTransicao(double temperatura, boolean falhaResfriamento) {
        if (falhaResfriamento) {
            System.out.println("Alerta vermelho -> Emergência (falha no resfriamento)");
            usina.setEstado(new Emergencia(usina));
        } else if (temperatura < 350) {
            System.out.println("Alerta vermelho -> Alerta amarelo (temperatura normalizando)");
            usina.setEstado(new AlertaAmarelo(usina));
        }
    }
}
