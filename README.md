# AutomRecupera25

## Descrição
Projeto de automação de testes para o sistema Recupera, focado na funcionalidade de acordos para clientes CCR e CBR.

## Tecnologias Utilizadas
- Java 11
- Maven
- Cucumber
- Selenium WebDriver
- Renner Framework (rnf-web e rnf-core)

## Estrutura do Projeto
```
src/
├── test/
│   ├── java/
│   │   └── br/
│   │       └── com/
│   │           └── renner/
│   │               └── interactions/
│   │                   ├── acordo/
│   │                   │   └── AcordoInteraction.java
│   │                   ├── cancAcordo/
│   │                   │   └── CancAcordoInteraction.java
│   │                   ├── consulta/
│   │                   │   └── consultaAcordoInteraction.java
│   │                   ├── GerarReneg/
│   │                   │   └── GerarRenegInteraction.java
│   │                   └── login/
│   │                       └── LoginInteraction.java
│   │               └── pages/
│   │                   ├── acordo/
│   │                   │   └── AcordoPage.java
│   │                   ├── cancAcordo/
│   │                   │   └── CancAcordoPage.java
│   │                   ├── consulta/
│   │                   │   └── consultaAcordoPage.java
│   │                   ├── GerarReneg/
│   │                   │   └── GerarRenegPage.java
│   │                   └── login/
│   │                       └── LoginPage.java
│   │               └── runner/
│   │                   └── WebRunnerTest.java
│   │               └── steps/
│   │                   ├── acordo/
│   │                   │   └── AcordoStep.java
│   │                   ├── cancAcordo/
│   │                   │   └── CancAcordoStep.java
│   │                   ├── consulta/
│   │                   │   └── consultaAcordoStep.java
│   │                   ├── GerarReneg/
│   │                   │   └── GerarRenegStep.java
│   │                   ├── hook/
│   │                   │   └── WebSetup.java
│   │                   └── login/
│   │                       └── LoginStep.java
│   │               └── toolbox/
│   │                   ├── GlobalTools.java
│   │                   ├── RennerTools.java
│   │                   └── SetupTestRunProperties.java
│   │               └── utils/
│   │                   ├── ConsultaCliente.java
│   │                   ├── CpfCache.java
│   │                   ├── DatabaseUtils.java
│   │                   └── JsonUtils.java
│   └── resources/
│       └── configs/
│           └── data/
│               └── testData.json
│       └── features/
│           ├── 01_login/
│           │   └── Login.feature
│           ├── 02_consulta/
│           │   └── Consutla.feature
│           ├── 03_acordo/
│           │   └── Acordo.feature
│           ├── 04_gerarReneg/
│           │   └── GerarReneg.feature
│           └── 05_cancelaACordo/
│               └── CancelaAcordo.feature
│       └── imagens/
│           └── img.png
```

## Funcionalidades Testadas
### Login
- Login com usuario valido

### Consulta
- Consulta cliente com divida (CCR e CBR)

### Acordos
- Acordos à vista sem desconto (CCR e CBR)
- Acordos à vista com desconto (CCR e CBR)
- Acordos parcelados sem desconto (CCR e CBR)
- Acordos parcelados com desconto (CCR e CBR)

### Gerar Reneg
- Gerar Reneg (CCR e CBR)

### Cancela Acordo
- Cancela Acordo (CCR e CBR)

## Pré-requisitos
- Java 11 instalado
- Maven instalado
- Chrome Browser instalado
- Acesso ao sistema Recupera

## Configuração do Ambiente
1. Clone o repositório
2. Configure o arquivo `rnframework.properties` com as credenciais necessárias
3. Execute `mvn clean install` para baixar as dependências

## Executando os Testes
Para executar um cenário específico:
```bash
mvn clean test -Dtest=WebRunnerTest
```

Para executar um cenário específico com tag:
```bash
mvn clean test -Dtest=WebRunnerTest -Dcucumber.filter.tags="@NomeDaTag"
```

## Relatórios
Os relatórios são gerados automaticamente após a execução dos testes no diretório `reports/`:
- HTML: `reports/cucumber.html`
- JSON: `reports/cucumber.json`
- XML: `reports/cucumber.xml`

## Tags Disponíveis
- @Login

### CCR
- @ConsultaCCR
- @AVistaSemDescontoCCR
- @AVistaComDescontoCCR
- @ParceladoSemDescontoCCR
- @ParceladoComDescontoCCR
- @CriarRenegCCR
- @CancAcordoCCR

### CBR
- @ConsultaCBR
- @AVistaSemDescontoCBR
- @AVistaComDescontoCBR
- @ParceladoSemDescontoCBR
- @ParceladoComDescontoCBR
- @CriarRenegCBR
- @CancAcordoCBR

## Manutenção
Para adicionar novos cenários:
1. Adicione o novo cenário no arquivo `Acordo.feature`
2. Implemente os steps necessários em `AcordoStep.java`
3. Execute os testes para validar a implementação

## Suporte
Em caso de dúvidas ou problemas, entre em contato com a equipe de automação.

