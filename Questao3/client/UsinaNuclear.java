package client;
import estados.Desligada;
import interfaces.IEstado;

public class UsinaNuclear {
    private IEstado _estado;
    
    public UsinaNuclear() {
        this._estado = new Desligada(this);
    }
    
    public IEstado getEstado() {
        return _estado;
    }
    
    public void setEstado(IEstado estado) {
        this._estado = estado;
    }
 
    public void ligarUsina() {
        _estado.setOperacaoNormal();
    }
    
    public void desligarUsina() {
        _estado.setDesligada();
    }

    public void iniciarManutencao() {
        _estado.iniciarManutencao();
    }

    public void finalizarManutencao() {
        _estado.finalizarManutencao();
    }

    public void verificarCondicoes(double temperatura, boolean falhaResfriamento) {
        _estado.verificarTransicao(temperatura, falhaResfriamento);
    }

    public void forcarAlertaAmarelo() {
        _estado.setAlertaAmarelo();
    }

    public void forcarAlertaVermelho() {
        _estado.setAlertaVermelho();
    }

    public void forcarEmergencia() {
        _estado.setEmergencia();
    }
}