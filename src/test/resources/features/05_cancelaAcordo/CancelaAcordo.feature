#language: pt

@CancelaAcordo
Funcionalidade: Cancelar acordo

  Contexto:
    Dado que estou no recupera

  @EsqCancAcordoCliente
  Esquema do Cenario: EsqCancAcordoCliente
    Quando pesquiso cliente com acordo "<cliente>"
    E cancelo acordo
    Entao acordo cancelado com sucesso

    Exemplos:
      | cliente |
      | CCR     |
      | CBR     |


  @EsqCancAcordoLista
  Esquema do Cenario: EsqCancAcordoLista
    Quando pesquiso clientes com acordo "<cpf>"
    E cancelo acordo
    Entao acordo cancelado com sucesso

    Exemplos:
      | cpf         |
#      | 21825210381 |
      | 27467430787 |
      | 28586735000 |

  @CancAcordoCCR
  Cenario: CancelaAcordoCCR
    Quando pesquiso cliente com acordo "CCR"
    E cancelo acordo
    Entao acordo cancelado com sucesso


  @CancAcordoCBR
  Cenario: CancelaAcordoCBR
    Quando pesquiso cliente com acordo "CBR"
    E cancelo acordo
    Entao acordo cancelado com sucesso
