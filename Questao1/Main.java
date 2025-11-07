package Questao1;

import Questao1.algoritmos.ExpectedShortfall;
import Questao1.contexto.Contexto;
import Questao1.modelos.ModeloRisco;

public class Main {
    ModeloRisco modelo = new ModeloRisco(1000.00, 90.00, 95.00);
    Contexto contexto = new Contexto(new ExpectedShortfall());

    contexto.analisar(modelo);

    contexto.setAlgoritmo(new StressTesting());
    contexto.analisar(modelo);

    contexto.setAlgoritmo(new ValueAtRisk());
    contexto.analisar(modelo);
}
