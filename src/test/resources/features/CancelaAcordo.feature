#language: pt

@CancelaAcordo
Funcionalidade: Cancelar acordo

  Contexto:
    Dado que estou no recupera

  @EsquemaCancelaAcordoCliente
  Esquema do Cenario: Cancelar acordo
    Quando pesquiso cliente com acordo "<cliente>"
    E cancelo acordo
    Entao acordo cancelado com sucesso "<cliente>"

    Exemplos:
      | cliente |
      | CCR     |
      | CBR     |


  @CancelaAcordoCCR
  Cenario: Cancelar acordo CCR
    Quando pesquiso cliente com acordo "CCR"
    E cancelo acordo
    Entao acordo cancelado com sucesso "CCR"


  @CancelaAcordoCBR
  Cenario: Cancelar acordo CBR
    Quando pesquiso cliente com acordo "CBR"
    E cancelo acordo
    Entao acordo cancelado com sucesso "CBR"
