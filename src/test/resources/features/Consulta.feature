#language: pt

@Consulta
Funcionalidade: Consulta Cliente

  Contexto:
    Dado que estou na pagina do recupera

  @EsquemaConsultaCliente
  Esquema do Cenario: Consulta cliente com divida
    Quando Clico em operacao
    E pesquiso pelo cliente "<cliente>"
    Entao consulta realizada com sucesso

    Exemplos:
      | cliente |
      | CCR     |
      | CBR     |


  @ConsultaCCR
  Cenario: Consulta cliente com divida CCR
    Quando Clico em operacao
    E pesquiso pelo cliente "CCR"
    Entao consulta realizada com sucesso


  @ConsultaCBR
  Cenario: Consulta cliente com divida CBR
    Quando Clico em operacao
    E pesquiso pelo cliente "CCR"
    Entao consulta realizada com sucesso

