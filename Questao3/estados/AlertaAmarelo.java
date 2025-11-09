package estados;

import client.UsinaNuclear;

public class AlertaAmarelo extends EstadoGenerico {

    private int tempo = (int)(Math.random() * 60 + 1);

    public AlertaAmarelo(UsinaNuclear usina) {
        super(usina);
    }

    @Override
    public void verificarTransicao(double temperatura, boolean falhaResfriamento) {
        if (temperatura > 400) {
            if (tempo >= 30) {
                System.out.println("Alerta Amarelo -> Alerta Vermelho (temperatura > 400°C por mais de 30s)");
                usina.setEstado(new AlertaVermelho(usina));
            }
        } else if (temperatura < 300) {
            System.out.println("Alerta Amarelo -> OperacaoNormal (temperatura normalizada)");
            usina.setEstado(new OperacaoNormal(usina));
        }
    }

    @Override
    public void setAlertaVermelho() {
        System.out.println("Alerta Amarelo -> Alerta Vermelho (forçado)");
        usina.setEstado(new AlertaVermelho(usina));
    }

    @Override
    public void setOperacaoNormal() {
        System.out.println("Alerta amarelo -> Operacao normal (forçado)");
        usina.setEstado(new OperacaoNormal(usina));
    }

    @Override
    public void setDesligada() {
        System.out.println("Alerta amarelo -> Desligada (desligando usina)");
        usina.setEstado(new Desligada(usina));
    } 

    @Override
    public void iniciarManutencao() {
        System.out.println("Alerta amarelo -> Manutenção");
        usina.setEstado(new Manutencao(usina));
    }
}