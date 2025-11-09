package estados;

import client.UsinaNuclear;
import interfaces.IEstado;

public class Manutencao extends EstadoGenerico {
    private IEstado estadoAnterior;

    protected Manutencao(UsinaNuclear usina) {
        super(usina);
        this.estadoAnterior = usina.getEstado();
    }

    @Override
    public void verificarTransicao(double temperatura, boolean falhaResfriamento) {
        System.out.println("Usina em Manutenção: Parâmetros não podem ser verificados agora.");
    }
    
    @Override
    public void setDesligada() {
        System.out.println("Manutenção -> Desligada (forçado)");
        usina.setEstado(new Desligada(usina));
    }

    @Override
    public void finalizarManutencao() {
        System.out.println("Manutenção finalizada: retornando ao estado anterior (" + estadoAnterior.getClass().getSimpleName() + ")");
        usina.setEstado(estadoAnterior);
    }

    @Override
    public void iniciarManutencao() {
        System.out.println("A usina já está em manutenção.");
    }
}
