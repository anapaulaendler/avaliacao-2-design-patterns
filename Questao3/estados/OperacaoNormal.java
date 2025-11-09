package estados;

import client.UsinaNuclear;

public class OperacaoNormal extends EstadoGenerico {

    public OperacaoNormal(UsinaNuclear usina) {
        super(usina);
    }

    @Override
    public void setOperacaoNormal() {
        System.out.println("Usina já está ligada e operando normalmente.");
    }

    @Override
    public void setDesligada() {
        System.out.println("Operação normal -> Desligada (desligando usina)");
        usina.setEstado(new Desligada(usina));
    } 

    @Override
    public void setAlertaAmarelo() {
        System.out.println("Operação normal -> Alerta amarelo (forçado)");
        usina.setEstado(new AlertaAmarelo(usina));
    }

    @Override
    public void iniciarManutencao() {
        System.out.println("Operação normal -> Manutenção");
        usina.setEstado(new Manutencao(usina));
    }

    @Override
    public void verificarTransicao(double temperatura, boolean falhaResfriamento) {
        if (temperatura > 300) {
            System.out.println("Operação normal -> Alerta Amarelo (temperatura > 300°C)");
            usina.setEstado(new AlertaAmarelo(usina));
        }
    }   
}
