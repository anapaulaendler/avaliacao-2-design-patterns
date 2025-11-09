package estados;

import client.UsinaNuclear;

public class Emergencia extends EstadoGenerico {

    public Emergencia(UsinaNuclear usina) {
        super(usina);
    }

    @Override
    public void verificarTransicao(double temperatura, boolean falhaResfriamento) {
        System.out.println("!!! EMERGÊNCIA ATIVA !!!");
        System.out.println("Todos os sistemas estão paralisados até resetar manualmente.");
    }

    @Override
    public void setDesligada() {
        System.out.println("Emergencia -> Desligada (desligando usina)");
        usina.setEstado(new Desligada(usina));
    } 

    @Override
    public void iniciarManutencao() {
        System.out.println("Emergência -> Manutenção");
        usina.setEstado(new Manutencao(usina));
    }

    @Override
    public void setEmergencia() {
        System.out.println("Usina já está em estado de emergência.");
    }
}