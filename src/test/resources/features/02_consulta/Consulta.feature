#language: pt

@Consulta
Funcionalidade: Consulta Cliente

  Contexto:
    Dado que estou na pagina do recupera

  @EsqConsultaCliente
  Esquema do Cenario: Consulta cliente com divida
    Quando Clico em operacao
    E pesquiso pelo cliente "<cliente>"
    Entao consulta realizada com sucesso

    Exemplos:
      | cliente |
      | CCR     |
      | CBR     |


  @ConsultaCCR
  Cenario: ClienteCCR
    Quando Clico em operacao
    E pesquiso pelo cliente "CCR"
    Entao consulta realizada com sucesso


  @ConsultaCBR
  Cenario: ClienteCBR
    Quando Clico em operacao
    E pesquiso pelo cliente "CBR"
    Entao consulta realizada com sucesso

