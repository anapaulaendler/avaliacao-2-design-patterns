package estados;

import client.UsinaNuclear;

public class Desligada extends EstadoGenerico {

    public Desligada(UsinaNuclear usina) {
        super(usina);
    }

    @Override
    public void setOperacaoNormal() {
        System.out.println("Desligada -> OperacaoNormal (ligando usina)");
        usina.setEstado(new OperacaoNormal(usina));
    }

    @Override
    public void verificarTransicao(double temperatura, boolean falhaResfriamento) {
        System.out.println("Usina desligada: condições inválidas para verificação.");
    }

    @Override
    public void setDesligada() {
        System.out.println("Usina já está desligada.");
    }
}
