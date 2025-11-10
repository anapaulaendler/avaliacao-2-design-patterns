# Questão 1 - Sistema de Processamento de Dados

## Descrição
### Contexto
Você está desenvolvendo um sistema de processamento de dados para uma empresa financeira que lida com diferentes tipos de análise de risco. O sistema precisa calcular métricas de risco usando diferentes algoritmos (Value at Risk, Expected Shortfall, Stress Testing) que podem mudar dinamicamente durante a execução.

### Problema
- Cada algoritmo de risco deve ser intercambiável em tempo de execução
- Os algoritmos devem ser capazes de compartilhar um contexto complexo com múltiplos parâmetros financeiros
- Deve ser possível trocar de algoritmo de acordo com a necessidade de negócios

### Restrições
- O cliente deve poder mudar de algoritmo sem conhecer os detalhes de implementação
- Implemente pelo menos 3 algoritmos diferentes com cálculos dummy (podem ser mensagens de texto) distintos

## Justificativa do Padrão
Decidi aplicar o padrão de projeto **Strategy**, já que a questão exige que o cliente possa mudar de algoritmo utilizado para o cálculo de riscos sem conhecer detalhes da sua implementação e ele deve ser **intercambiável** durante a execução. 

O padrão Strategy se mostrou ideal na situação por conseguir entregar o requisitado e possibilitar que, usando um `ModeloRisco`, o cliente consiga analisar o seu (`ModeloRisco`) risco utilizando diversos algoritmos por meio que um `Contexto`, o qual permite a troca dinâmica de algoritmos.

## Diagrama UML
![]()

# Questão 2 - Sistema Bancário

## Descrição
### Contexto
Sua empresa está integrando com um legado bancário que possui uma interface complexa para processamento de transações. A interface legada `SistemaBancarioLegado` possui métodos com assinaturas incompatíveis e usa tipos de dados obsoletos.

### Problema:
- Converter a interface atualizada ProcessadorTransacoes (com métodos `autorizar(String cartao, double valor, String moeda)`) para a interface legada
- O sistema legado usa: `processarTransacao(HashMap<String, Object> parametros)`
- Implemente de forma que o funcionamento seja bidirecional, ou seja, que também permita converter respostas do legado para o formato atualizado
- Adicione tratamento para campos obrigatórios do legado que não existem na interface moderna (ao menos um)

### Restrições:
- O legado exige codificação específica para moedas (USD=1, EUR=2, BRL=3)

## Justificativa do Padrão
Decidi aplicar o padrão de projeto **Adapter** porque estamos lidando com um sistema legado (`SistemaBancarioLegado`), cujas respostas precisam ser adaptadas para uma interface moderna.

O Adapter funciona tomando o sistema legado como parâmetro e literalmente adaptando as respostas desse sistema para um atualizando, fazendo as devidas alterações para que os sistemas consigam interagir entre si sem quebrar.

## Diagrama UML
![]()

# Questão 3 - Sistema de Usina Nuclear

## Descrição
### Contexto
Você está modelando um sistema de controle para uma usina nuclear com estados complexos de operação. A usina pode estar em: DESLIGADA, OPERACAO_NORMAL, ALERTA_AMARELO, ALERTA_VERMELHO, EMERGENCIA.

### Problema:
- Cada transição de estado deve validar condições complexas (temperatura, pressão, nível de radiação)
- Algumas transições são bidirecionais, outras são unidirecionais
- Previna transições circulares perigosas
- O estado EMERGENCIA só pode ser ativado após passar por ALERTA_VERMELHO
- Adicione um modo "manutenção" que sobreescreva temporariamente os estados normais

### Regras
- OPERACAO_NORMAL → ALERTA_AMARELO: se temperatura > 300°C
- ALERTA_AMARELO → ALERTA_VERMELHO: se temperatura > 400°C por mais de 30 segundos
- ALERTA_VERMELHO → EMERGENCIA: se sistema de resfriamento falhar

## Justificativa do Padrão
Decidi aplicar o padrão de projeto **State**, porque organiza os comportamentos de um objeto conforme seu estado atual. Além disso, evita condicionais complexos e facilita a manutenção de transições.
Dessa forma, elimino grandes blocos de switch/if na classe `UsinaNuclear`, e consigo trazer as restrições lógicas para transições de estado propostas para o sistema, como "O estado EMERGENCIA só pode ser ativado após passar por ALERTA_VERMELHO" 

## Diagrama UML
![]()

# Questão 4 - Sistema de Validação de Documentos

## Descrição
### Contexto
Desenvolva um sistema de validação de documentos fiscais eletrônicos (NF-e) que precisa aplicar múltiplas regras de validação em cadeia.

### Problema
- Cada validador especializado verifica um aspecto específico do documento
- A cadeia deve suportar validações condicionais (se validador X falhar, pule Y)
- Implemente um mecanismo de "circuit breaker" que interrompa a cadeia após 3 validações falharem
- Adicione capacidade de rollback para validadores que modificam o documento

### Validadores Requeridos
1. Validador de Schema XML contra XSD
2. Validador de Certificado Digital (expiração e revogação)
3. Validador de Regras Fiscais (cálculo de impostos)
4. Validador de Banco de dados (duplicidade de número)
5. Validador de Serviço SEFAZ (consulta online)

### Restrições
- Os validadores 3 e 5 devem ser executados apenas se os anteriores passarem
- O validador 4 deve fazer rollback da inserção se validações subsequentes falharem
- Implemente timeout individual para cada validador

## Justificativa do Padrão
Decidi aplicar o padrão de projeto **Chain of Responsibility**, porque distribui a responsabilidade entre vários objetos de forma sequencial. Além disso, evita código com muitos if/else encadeados.
Dessa forma, consigo dividir de forma adequada as validações por tipo, seguindo o princípio da Responsabilidade Única (SRP) do SOLID, e, por conta disso, agilizar operações de rollback por meio do conhecimento indivual de cada tipo de validação. 

## Diagrama UML
![]()
