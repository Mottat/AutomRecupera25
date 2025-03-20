#language: pt

@Acordo
Funcionalidade: Fazer acordo

  Contexto:
    Dado que estou na pagina inicial do recupera

  @AcordoCliente
  Esquema do Cenario: Acordo
    Quando Clico no menu operacao
    E faço um acordo "<cliente>"
    Entao acordo criado com sucesso

    Exemplos:
      | cliente |
      | CCR     |
      | CBR     |


  @AcordoCCR
  Cenario: Acordo CCR
    Quando Clico no menu operacao
    E faço um acordo "CCR"
    Entao acordo criado com sucesso

  @AcordoCBR
  Cenario: Acordo CBR
    Quando Clico no menu operacao
    E faço um acordo "CBR"
    Entao acordo criado com sucesso
