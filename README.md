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
│   │               ├── runner/
│   │               │   └── WebRunnerTest.java
│   │               └── steps/
│   │                   └── AcordoStep.java
│   └── resources/
│       └── features/
│           └── Acordo.feature
```

## Funcionalidades Testadas
### Acordos
- Acordos à vista sem desconto (CCR e CBR)
- Acordos à vista com desconto (CCR e CBR)
- Acordos parcelados sem desconto (CCR e CBR)
- Acordos parcelados com desconto (CCR e CBR)

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
### CCR
- @AVistaSemDescontoCCR
- @AVistaComDescontoCCR
- @ParceladoSemDescontoCCR
- @ParceladoComDescontoCCR

### CBR
- @AVistaSemDescontoCBR
- @AVistaComDescontoCBR
- @ParceladoSemDescontoCBR
- @ParceladoComDescontoCBR

## Manutenção
Para adicionar novos cenários:
1. Adicione o novo cenário no arquivo `Acordo.feature`
2. Implemente os steps necessários em `AcordoStep.java`
3. Execute os testes para validar a implementação

## Suporte
Em caso de dúvidas ou problemas, entre em contato com a equipe de automação.

