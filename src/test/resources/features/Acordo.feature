#language: pt

@Acordo
Funcionalidade: Fazer acordo

  Contexto:
    Dado que estou na pagina inicial do recupera

  @EsquemaAcordoCliente
  Esquema do Cenario: Acordo
    Quando Clico no menu operacao
    E faço um acordo "<cliente>" e "<quantidade>" e "<desconto>"
    Entao acordo criado com sucesso

    Exemplos:
      | cliente | quantidade | desconto
      | CCR     | 2          | 0
      | CBR     | 3          | 0


#    Cenários CCR
  @AcordoAVistaSemDescontoCCR
  Cenario: Acordo CCR
    Quando Clico no menu operacao
    E faço um acordo "CCR" e "0" e "0"
    Entao acordo criado com sucesso

  @AcordoAVistaComDescontoCCR
  Cenario: Acordo CCR
    Quando Clico no menu operacao
    E faço um acordo "CCR" e "0" e "50"
    Entao acordo criado com sucesso

  @AcordoParceladoSemDescontoCCR
  Cenario: Acordo CCR
    Quando Clico no menu operacao
    E faço um acordo "CCR" e "2" e "0"
    Entao acordo criado com sucesso

  @AcordoParceladoComDescontoCCR
  Cenario: Acordo CCR
    Quando Clico no menu operacao
    E faço um acordo "CCR" e "3" e "50"
    Entao acordo criado com sucesso



#    Cenários CBR
  @AcordoAVistaSemDescontoCBR
  Cenario: Acordo CBR
    Quando Clico no menu operacao
    E faço um acordo "CBR" e "0" e "0"
    Entao acordo criado com sucesso

  @AcordoAVistaComDescontoCBR
  Cenario: Acordo CBR
    Quando Clico no menu operacao
    E faço um acordo "CBR" e "0" e "50"
    Entao acordo criado com sucesso

  @AcordoParceladoSemDescontoCBR
  Cenario: Acordo CBR
    Quando Clico no menu operacao
    E faço um acordo "CBR" e "4" e "0"
    Entao acordo criado com sucesso

  @AcordoParceladoComDescontoCBR
  Cenario: Acordo CBR
    Quando Clico no menu operacao
    E faço um acordo "CBR" e "5" e "50"
    Entao acordo criado com sucesso
