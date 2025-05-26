#language: pt

@Acordo
Funcionalidade: Fazer acordo

  Contexto:
    Dado que estou na pagina inicial do recupera

  @EsqAcordoCliente
  Esquema do Cenario: EsqAcordoCliente
    Quando clico no menu operacao
    E faço um acordo "<cliente>" e "<quantidade>" e "<desconto>"
    Entao acordo criado com sucesso

    Exemplos:
      | cliente | quantidade | desconto |
      | CCR     | 2          | 50       |
      | CBR     | 1          | 20       |


#    Cenários CCR
  @AVistaSemDescontoCCR
  Cenario: AVistaSemDescontoCCR
    Quando clico no menu operacao
    E faço um acordo "CCR" e "0" e "0"
    Entao acordo criado com sucesso

  @AVistaComDescontoCCR
  Cenario: AVistaComDescontoCCR
    Quando clico no menu operacao
    E faço um acordo "CCR" e "0" e "50"
    Entao acordo criado com sucesso

  @ParceladoSemDescontoCCR
  Cenario: ParceladoSemDescontoCCR
    Quando clico no menu operacao
    E faço um acordo "CCR" e "2" e "0"
    Entao acordo criado com sucesso

  @ParceladoComDescontoCCR
  Cenario: ParceladoComDescontoCCR
    Quando clico no menu operacao
    E faço um acordo "CCR" e "3" e "50"
    Entao acordo criado com sucesso



#    Cenários CBR
  @AVistaSemDescontoCBR
  Cenario: AVistaSemDescontoCBR
    Quando clico no menu operacao
    E faço um acordo "CBR" e "0" e "0"
    Entao acordo criado com sucesso

  @AVistaComDescontoCBR
  Cenario: AVistaComDescontoCBR
    Quando clico no menu operacao
    E faço um acordo "CBR" e "0" e "50"
    Entao acordo criado com sucesso

  @ParceladoSemDescontoCBR
  Cenario: ParceladoSemDescontoCBR
    Quando clico no menu operacao
    E faço um acordo "CBR" e "4" e "0"
    Entao acordo criado com sucesso

  @ParceladoComDescontoCBR
  Cenario: ParceladoComDescontoCBR
    Quando clico no menu operacao
    E faço um acordo "CBR" e "5" e "50"
    Entao acordo criado com sucesso
