import client.UsinaNuclear;

public class Main {
    public static void main(String[] args) {
        UsinaNuclear usina = new UsinaNuclear();

        usina.ligarUsina();
        usina.forcarAlertaAmarelo();
        
        usina.iniciarManutencao();
        usina.forcarAlertaVermelho();
        usina.verificarCondicoes(45.45, false);
        usina.finalizarManutencao();

        usina.desligarUsina();
        usina.forcarAlertaAmarelo();
        
        usina.ligarUsina();
        usina.verificarCondicoes(2666.00, false);
        usina.verificarCondicoes(250.00, false);
        usina.verificarCondicoes(2666.00, false);
        usina.verificarCondicoes(2666.00, true);
        usina.desligarUsina();
    }
}
